package com.example.jumia_Ecommerce.productSuppllier.DTO.request;

import com.example.jumia_Ecommerce.model.data.Address;
import lombok.Data;

@Data
public class UpdateProductSupplierRequest {
    private String productSupplierUserName, productSupplierEmailAddress;

    private String userName;

    private String password;

    private String phoneNumber;

    private String emailAddress;
    private Address address;
}
