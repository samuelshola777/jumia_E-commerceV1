package com.example.jumia_Ecommerce.jumiaDropOffWareHouse.DTO.requests;

import lombok.Data;

@Data
public class UpdateWareHouseRequest {
    private String oldWareHouseName;
    private String newWareHouseName;
    private String buildingNumber;
    private String streetName;
    private String locationGovernmentName;
    private String state;
}
