package com.example.jumia_Ecommerce.jumiaDropOffWareHouse.service.implementation;

import com.example.jumia_Ecommerce.jumiaDropOffWareHouse.DTO.requests.UpdateWareHouseRequest;
import com.example.jumia_Ecommerce.jumiaDropOffWareHouse.DTO.requests.WareHouseRequest;
import com.example.jumia_Ecommerce.jumiaDropOffWareHouse.DTO.response.WareHouseLoginResponse;
import com.example.jumia_Ecommerce.jumiaDropOffWareHouse.DTO.response.WareHouseResponse;
import com.example.jumia_Ecommerce.jumiaDropOffWareHouse.data.model.WareHouse;
import com.example.jumia_Ecommerce.jumiaDropOffWareHouse.data.repository.WareHouseRepository;
import com.example.jumia_Ecommerce.jumiaDropOffWareHouse.exception.WareHouseRegistrationException;
import com.example.jumia_Ecommerce.jumiaDropOffWareHouse.service.interfaces.WareHouseService;
import com.example.jumia_Ecommerce.model.data.Address;
import com.example.jumia_Ecommerce.service.interfaces.AddressService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Transactional
@RequiredArgsConstructor
public class WareHouseServiceIMPL implements WareHouseService {

    private final WareHouseRepository wareHouseRepository;
    private final AddressService addressService;

    @Override
    public WareHouseResponse registerNewWareHouse(WareHouseRequest wareHouseRequest) {
        String wareHouseName = wareHouseRequest.getWareHouesAddress().getStreetName();
        if (wareHouseRepository.existsByWareHouseName(wareHouseName))
            throw new WareHouseRegistrationException("Warehouse already exists");
        Address savedAddress = addressService.savedAddress(wareHouseRequest.getWareHouesAddress());
        WareHouse newWareHouse = WareHouse.builder()
                .wareHouesAddress(savedAddress)
                .createAt(LocalDateTime.now())
                .wareHouseName(wareHouseName)
                .build();
        wareHouseRepository.save(newWareHouse);
        return WareHouseResponse.builder().warehouseName(wareHouseName).build();
    }

    @Override
    public WareHouseResponse updateWareHouse(UpdateWareHouseRequest updateWareHouseRequest) {
    if (wareHouseRepository.existsByWareHouseName(updateWareHouseRequest.getNewWareHouseName()))
        throw new WareHouseRegistrationException("the name "+updateWareHouseRequest.getNewWareHouseName()+" already exists");
    WareHouse foundWareHouse = findWareHouseByName(updateWareHouseRequest.getOldWareHouseName());
    Address foundAddress = foundWareHouse.getWareHouesAddress();
        if (updateWareHouseRequest.getState() != null){
            foundAddress.setState(updateWareHouseRequest.getState());
        }
        if (updateWareHouseRequest.getBuildingNumber() != null){
            foundAddress.setBuildingNumber(updateWareHouseRequest.getBuildingNumber());
        }
        if (updateWareHouseRequest.getLocationGovernmentName() != null){
            foundAddress.setLocationGovernmentName(updateWareHouseRequest.getLocationGovernmentName());
        }
        if (updateWareHouseRequest.getStreetName() != null){
            foundWareHouse.setWareHouseName(updateWareHouseRequest.getStreetName());
        }
        foundWareHouse.setWareHouesAddress(foundAddress);
        foundWareHouse.setWareHouseName(updateWareHouseRequest.getNewWareHouseName());
        foundWareHouse.setLastUpdated(LocalDateTime.now());
        wareHouseRepository.save(foundWareHouse);
        return WareHouseResponse.builder().warehouseName(foundWareHouse.getWareHouseName()).build();
    }

    @Override
    public WareHouse findWareHouseByName(String wareHouseName) {
        WareHouse foundWareHouse = wareHouseRepository.findByWareHouseName(wareHouseName);
        if (foundWareHouse == null)
        throw new WareHouseRegistrationException("warehouse with name "+wareHouseName+" does not exist");
        return foundWareHouse;
    }

    @Override
    public void deleteWareHouseByName(String wareHouseName) {
        addressService.deleteAddressByStreetName(wareHouseName);
    wareHouseRepository.delete(findWareHouseByName(wareHouseName));
    }

    @Override
    public long countWareHouse() {
        return wareHouseRepository.count();
    }

    @Override
    public void deleteAllWareHouse() {
        wareHouseRepository.deleteAll();
    }

    @Override
    public WareHouseLoginResponse loginToWareHouseDashBoard(String wareHouseName, String password) {
        WareHouse foundWareHouse = findWareHouseByName(wareHouseName);
        if (!password.equalsIgnoreCase(foundWareHouse.getPassword())) throw new WareHouseRegistrationException("login failed  \uD83D\uDE48\uD83D\uDE48\uD83D\uDE49\uD83D\uDE49\uD83D\uDE4A\uD83D\uDE4A\n");


        return null;
    }

}

