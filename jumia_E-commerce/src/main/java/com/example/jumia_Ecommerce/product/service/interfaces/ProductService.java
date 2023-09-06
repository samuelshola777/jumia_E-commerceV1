package com.example.jumia_Ecommerce.product.service.interfaces;

import com.example.jumia_Ecommerce.product.DTO.response.ProductResponse;
import com.example.jumia_Ecommerce.product.data.model.Product;

import java.util.List;

public interface ProductService {

    ProductResponse mapToProductResponse(Product product);
    List<ProductResponse> getAllProductByWareHouseName(String wareHouseName);

}
