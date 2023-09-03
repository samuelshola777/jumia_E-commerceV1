package com.example.jumia_Ecommerce.product.service.interfaces;

import com.example.jumia_Ecommerce.product.DTO.response.ProductResponse;
import com.example.jumia_Ecommerce.product.data.model.Product;

public interface ProductService {

    ProductResponse mapToProductResponse(Product product);

}
