package com.example.jumia_Ecommerce.productSuppllier.DTO.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductSupplierResponse {
    private String mobileNetwork;
    private String userName;
    private String phoneNumber;
}
