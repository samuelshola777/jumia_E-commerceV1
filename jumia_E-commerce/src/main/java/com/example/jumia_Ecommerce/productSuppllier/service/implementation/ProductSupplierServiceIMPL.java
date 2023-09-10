package com.example.jumia_Ecommerce.productSuppllier.service.implementation;

import com.example.jumia_Ecommerce.jumiaUser.data.model.JumiaUser;
import com.example.jumia_Ecommerce.productSuppllier.DTO.request.ProductSupplierRequest;
import com.example.jumia_Ecommerce.productSuppllier.DTO.response.ProductSupplierResponse;
import com.example.jumia_Ecommerce.productSuppllier.service.interfaces.ProductSupplierService;
import com.example.jumia_Ecommerce.jumiaUser.service.interfaces.JumiaUserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class ProductSupplierServiceIMPL implements ProductSupplierService {
    private final JumiaUserService jumiaUserService;
    @Override
    public ProductSupplierResponse registerNewProductSupplier(ProductSupplierRequest productSupplierRequest1) {
// JumiaUser createdJumiaUser = jumiaUserService.registerNewJumiaUser(productSupplierRequest1);
        return null;
    }

}
