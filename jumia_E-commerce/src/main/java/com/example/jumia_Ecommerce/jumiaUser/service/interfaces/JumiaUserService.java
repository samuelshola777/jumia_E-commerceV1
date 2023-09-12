package com.example.jumia_Ecommerce.jumiaUser.service.interfaces;

import com.example.jumia_Ecommerce.jumiaUser.DTO.request.JumiaUserRequest;
import com.example.jumia_Ecommerce.jumiaUser.data.model.JumiaUser;
import com.example.jumia_Ecommerce.productSuppllier.DTO.request.ProductSupplierRequest;

import java.util.List;

public interface JumiaUserService {
    JumiaUser registerNewJumiaUser(JumiaUserRequest jumiaUserRequest);
    boolean ifExistByEmail(String email);
    boolean ifExistByUsername(String username);
    List<JumiaUser> findJumiaUserByUsername(String username);

}
