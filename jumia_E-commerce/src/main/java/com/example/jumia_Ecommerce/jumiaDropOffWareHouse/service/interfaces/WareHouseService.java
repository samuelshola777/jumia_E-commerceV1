package com.example.jumia_Ecommerce.jumiaDropOffWareHouse.service.interfaces;

import com.example.jumia_Ecommerce.jumiaDropOffWareHouse.DTO.requests.UpdateWareHouseRequest;
import com.example.jumia_Ecommerce.jumiaDropOffWareHouse.DTO.requests.WareHouseRequest;
import com.example.jumia_Ecommerce.jumiaDropOffWareHouse.DTO.response.WareHouseLoginResponse;
import com.example.jumia_Ecommerce.jumiaDropOffWareHouse.DTO.response.WareHouseResponse;
import com.example.jumia_Ecommerce.jumiaDropOffWareHouse.data.model.WareHouse;

public interface WareHouseService {
    WareHouseResponse registerNewWareHouse(WareHouseRequest wareHouseRequest1);
    WareHouseResponse updateWareHouse(UpdateWareHouseRequest updateWareHouseRequest);
    WareHouse findWareHouseByName(String wareHouseName);
   boolean deleteWareHouseByName(String wareHouseName);
    long countWareHouse();

    boolean deleteAllWareHouse();

     WareHouseLoginResponse loginToWareHouseDashBoard(String wareHouseName, String password);
}
