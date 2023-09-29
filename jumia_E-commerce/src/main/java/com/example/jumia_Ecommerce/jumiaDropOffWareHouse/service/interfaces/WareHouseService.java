package com.example.jumia_Ecommerce.jumiaDropOffWareHouse.service.interfaces;

import com.example.jumia_Ecommerce.generalEnums.Product_Categories;
import com.example.jumia_Ecommerce.jumiaDropOffWareHouse.DTO.requests.UpdateWareHouseRequest;
import com.example.jumia_Ecommerce.jumiaDropOffWareHouse.DTO.requests.WareHouseRequest;
import com.example.jumia_Ecommerce.jumiaDropOffWareHouse.DTO.response.WareHouseLoginResponse;
import com.example.jumia_Ecommerce.jumiaDropOffWareHouse.DTO.response.WareHouseResponse;
import com.example.jumia_Ecommerce.jumiaDropOffWareHouse.data.model.WareHouse;
import com.example.jumia_Ecommerce.product.DTO.response.ProductResponse;

import java.util.List;

public interface WareHouseService {
    WareHouseResponse registerNewWareHouse(WareHouseRequest wareHouseRequest1);
    WareHouseResponse updateWareHouse(UpdateWareHouseRequest updateWareHouseRequest);
    WareHouse findWareHouseByName(String wareHouseName);
   boolean deleteWareHouseByName(String wareHouseName);
    long countWareHouse();

    boolean deleteAllWareHouse();

    Product_Categories[] getAllCategory(String wareHouseManagerEmail, String wareHouseName);

    void saveWareHouse(WareHouse foundWareHouse);
}
