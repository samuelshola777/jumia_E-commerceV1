package com.example.jumia_Ecommerce.jumiaDropOffWareHouse.DTO.requests;

import com.example.jumia_Ecommerce.model.data.Address;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class WareHouseRequest {
    private Address wareHouesAddress;
    private String wareHouseName;
}
