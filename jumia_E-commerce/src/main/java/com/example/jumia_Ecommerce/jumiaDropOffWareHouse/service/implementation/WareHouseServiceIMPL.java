package com.example.jumia_Ecommerce.jumiaDropOffWareHouse.service.implementation;

import com.example.jumia_Ecommerce.jumiaDropOffWareHouse.DTO.requests.WareHouseRequest;
import com.example.jumia_Ecommerce.jumiaDropOffWareHouse.DTO.response.WareHouseResponse;
import com.example.jumia_Ecommerce.jumiaDropOffWareHouse.data.model.WareHouse;
import com.example.jumia_Ecommerce.jumiaDropOffWareHouse.data.repository.WareHouseRepository;
import com.example.jumia_Ecommerce.jumiaDropOffWareHouse.exception.WareHouseRegistrationException;
import com.example.jumia_Ecommerce.jumiaDropOffWareHouse.service.interfaces.WareHouseService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class WareHouseServiceIMPL implements WareHouseService {
    private final WareHouseRepository warehouseRepository;



    @Override
    public WareHouseResponse registerNewWareHouse(WareHouseRequest wareHouseRequest1) {
    if (warehouseRepository.existsByWareHouseName(wareHouseRequest1.getWareHouesAddress().getStreetName())) throw new WareHouseRegistrationException("ware house already exist");
    warehouseRepository.save(WareHouse.builder()
    .wareHouesAddress(wareHouseRequest1.getWareHouesAddress())
    .wareHouseName(wareHouseRequest1.getWareHouesAddress().getStreetName())
    .build());
        return WareHouseResponse.builder().warehouseName(wareHouseRequest1.getWareHouesAddress().getStreetName()).build();
    }
}
