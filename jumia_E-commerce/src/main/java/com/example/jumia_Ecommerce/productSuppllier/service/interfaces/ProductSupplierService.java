package com.example.jumia_Ecommerce.productSuppllier.service.interfaces;

import com.example.jumia_Ecommerce.product.DTO.response.ProductResponse;
import com.example.jumia_Ecommerce.productSuppllier.DTO.request.ProductSupplierRequest;
import com.example.jumia_Ecommerce.productSuppllier.DTO.request.UpdateProductSupplierRequest;
import com.example.jumia_Ecommerce.productSuppllier.DTO.response.ProductSupplierResponse;
import com.example.jumia_Ecommerce.productSuppllier.data.model.ProductSupplier;

public interface ProductSupplierService {
    ProductSupplier findProductSupplierByUserName(String username);
    ProductSupplier findProductSupplierByEmailAddress(String emailAddress);
    ProductSupplierResponse updateProductSupplierDetails(UpdateProductSupplierRequest supplierUpdateRequest);
    ProductSupplierResponse registerNewProductSupplier(ProductSupplierRequest productSupplierRequest1);
}
