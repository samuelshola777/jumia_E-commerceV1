package com.example.jumia_Ecommerce.jumiaDropOffWareHouse.DTO.requests;

import com.example.jumia_Ecommerce.model.data.Address;
import lombok.Data;

@Data
public class WareHouseRequest {
    private Address wareHouesAddress;
    private String wareHouseName;
}
