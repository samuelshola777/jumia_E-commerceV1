package com.example.jumia_Ecommerce.jumiaUser.service.interfaces;

import com.example.jumia_Ecommerce.jumiaUser.DTO.request.JumiaUserRequest;
import com.example.jumia_Ecommerce.jumiaUser.data.model.JumiaUser;
import com.example.jumia_Ecommerce.productSuppllier.DTO.request.ProductSupplierRequest;

public interface JumiaUserService {
    JumiaUser registerNewJumiaUser(JumiaUserRequest jumiaUserRequest);
}
