package com.example.jumia_Ecommerce.jumiaDropOffWareHouse.service.interfaces;

import com.example.jumia_Ecommerce.jumiaUser.DTO.request.JumiaUserRequest;

public interface WareHouseManagerService {
    String registerNewWareHouse(JumiaUserRequest jumiaUserRequest, String wareHouseName);

    String loginAsWareHouseManager(String username, String password);

    void deleteAllWareHouseManager();
}
