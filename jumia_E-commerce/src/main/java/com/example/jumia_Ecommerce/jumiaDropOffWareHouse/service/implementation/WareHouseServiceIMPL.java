package com.example.jumia_Ecommerce.jumiaDropOffWareHouse.service.implementation;

import com.example.jumia_Ecommerce.generalEnums.Product_Categories;
import com.example.jumia_Ecommerce.jumiaDropOffWareHouse.DTO.requests.UpdateWareHouseRequest;
import com.example.jumia_Ecommerce.jumiaDropOffWareHouse.DTO.requests.WareHouseRequest;
import com.example.jumia_Ecommerce.jumiaDropOffWareHouse.DTO.response.WareHouseLoginResponse;
import com.example.jumia_Ecommerce.jumiaDropOffWareHouse.DTO.response.WareHouseResponse;
import com.example.jumia_Ecommerce.jumiaDropOffWareHouse.data.model.WareHouse;
import com.example.jumia_Ecommerce.jumiaDropOffWareHouse.data.repository.WareHouseRepository;
import com.example.jumia_Ecommerce.jumiaDropOffWareHouse.exception.WareHouseLoginException;
import com.example.jumia_Ecommerce.jumiaDropOffWareHouse.exception.WareHouseRegistrationException;
import com.example.jumia_Ecommerce.jumiaDropOffWareHouse.service.interfaces.WareHouseService;
import com.example.jumia_Ecommerce.model.data.Address;
import com.example.jumia_Ecommerce.product.DTO.response.ProductResponse;
import com.example.jumia_Ecommerce.product.service.interfaces.ProductService;
import com.example.jumia_Ecommerce.service.interfaces.AddressService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class WareHouseServiceIMPL implements WareHouseService {

    private final WareHouseRepository wareHouseRepository;
    private final AddressService addressService;
    private final ProductService productService;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;

    @Override
    public WareHouseResponse registerNewWareHouse(WareHouseRequest wareHouseRequest) {
        String wareHouseName = wareHouseRequest.getWareHouesAddress().getStreetName();
        if (wareHouseRepository.existsByWareHouseName(wareHouseName))
            throw new WareHouseRegistrationException("Warehouse already exists");
        Address savedAddress = addressService.savedAddress(wareHouseRequest.getWareHouesAddress());
        WareHouse newWareHouse = WareHouse.builder()
                .wareHouesAddress(savedAddress)
                .password(passwordEncoder.encode(wareHouseRequest.getPassword()))
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
        throw new WareHouseRegistrationException("warehouse with name >> "+wareHouseName+" << does not exist");
        return foundWareHouse;
    }

    @Override
    public boolean deleteWareHouseByName(String wareHouseName) {
        try {
            WareHouse foundWareHouse = findWareHouseByName(wareHouseName);
            wareHouseRepository.delete(foundWareHouse);
            return true;
        }catch (Exception e) {
            System.out.println(e.getMessage()+" ");
            return false;
        }
    }

    @Override
    public long countWareHouse() {
        return wareHouseRepository.count();
    }

    @Override
    public boolean deleteAllWareHouse() {
        wareHouseRepository.deleteAll();
        return true;
    }

    @Override
    public Product_Categories[] getAllCategory(String wareHouseManagerEmail, String wareHouseName) {
        WareHouse foundWareHouse = findWareHouseByName(wareHouseName);
        if (! foundWareHouse.getWareHouseManagerEmail().equalsIgnoreCase(wareHouseManagerEmail))
            throw new WareHouseLoginException
                    ("could not perform this operation due to the warehouseManager email does not match -> "+wareHouseManagerEmail);
        return Product_Categories.values();
    }

    @Override
    public void saveWareHouse(WareHouse foundWareHouse) {
        wareHouseRepository.save(foundWareHouse);
    }

}

