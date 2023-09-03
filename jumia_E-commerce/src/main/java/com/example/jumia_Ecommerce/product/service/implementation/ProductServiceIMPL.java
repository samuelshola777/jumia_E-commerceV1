package com.example.jumia_Ecommerce.product.service.implementation;

import com.example.jumia_Ecommerce.product.DTO.response.ProductResponse;
import com.example.jumia_Ecommerce.product.data.model.Product;
import com.example.jumia_Ecommerce.product.service.interfaces.ProductService;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Transactional
@Slf4j
public class ProductServiceIMPL implements ProductService {
    @Override
    public ProductResponse mapToProductResponse(Product product) {
        return ProductResponse.builder()
                .productName(product.getProductName())
                .productPrice(product.getProductPrice())
                .category(product.getCategory())
                .createdAt(product.getCreatedAt())
                .build();
    }
}
