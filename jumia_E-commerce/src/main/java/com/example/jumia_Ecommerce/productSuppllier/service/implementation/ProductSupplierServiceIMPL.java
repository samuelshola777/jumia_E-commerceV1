package com.example.jumia_Ecommerce.productSuppllier.service.implementation;

import com.example.jumia_Ecommerce.product.DTO.response.ProductResponse;
import com.example.jumia_Ecommerce.productSuppllier.DTO.request.ProductSupplierRequest;
import com.example.jumia_Ecommerce.productSuppllier.service.interfaces.ProductSupplierService;
import com.example.jumia_Ecommerce.service.interfaces.JumiaUserService;
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
    public ProductResponse registerNewProductSupplier(ProductSupplierRequest productSupplierRequest1) {
        return null;
    }
}
