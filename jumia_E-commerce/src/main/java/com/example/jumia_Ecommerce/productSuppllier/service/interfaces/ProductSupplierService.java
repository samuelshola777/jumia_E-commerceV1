package com.example.jumia_Ecommerce.productSuppllier.service.interfaces;

import com.example.jumia_Ecommerce.product.DTO.response.ProductResponse;
import com.example.jumia_Ecommerce.productSuppllier.DTO.request.ProductSupplierRequest;
import com.example.jumia_Ecommerce.productSuppllier.DTO.response.ProductSupplierResponse;

public interface ProductSupplierService {

    ProductSupplierResponse registerNewProductSupplier(ProductSupplierRequest productSupplierRequest1);
}
