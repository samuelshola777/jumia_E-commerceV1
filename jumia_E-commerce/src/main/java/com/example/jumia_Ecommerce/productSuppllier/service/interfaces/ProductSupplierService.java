package com.example.jumia_Ecommerce.productSuppllier.service.interfaces;

import com.example.jumia_Ecommerce.product.DTO.request.ProductRequest;
import com.example.jumia_Ecommerce.product.DTO.response.ProductResponse;
import com.example.jumia_Ecommerce.productSuppllier.DTO.request.ProductSupplierRequest;
import com.example.jumia_Ecommerce.productSuppllier.DTO.request.UpdateProductSupplierRequest;
import com.example.jumia_Ecommerce.productSuppllier.DTO.response.ProductSupplierResponse;
import com.example.jumia_Ecommerce.productSuppllier.data.model.ProductSupplier;

public interface ProductSupplierService {
    ProductSupplierResponse registerNewProductSupplier(ProductSupplierRequest productSupplierRequest1);
    ProductSupplier findProductSupplierByUserName(String username);
    ProductSupplier findProductSupplierByEmailAddress(String emailAddress);
    ProductSupplierResponse updateProductSupplierDetails(UpdateProductSupplierRequest supplierUpdateRequest);
    String deleteProductSupplierByName(String username);

    String deleteAllProductSupplier();

    ProductResponse supplyNewProduct(ProductRequest productRequest2);

    ProductSupplierResponse loginAsProductSupplier(String mail, String blueboat123);
}
