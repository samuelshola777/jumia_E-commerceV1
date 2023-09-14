package com.example.jumia_Ecommerce.product.service.implementation;

import com.example.jumia_Ecommerce.product.DTO.response.ProductResponse;
import com.example.jumia_Ecommerce.product.data.model.Product;
import com.example.jumia_Ecommerce.product.data.repository.ProductRepository;
import com.example.jumia_Ecommerce.product.exception.ProductException;
import com.example.jumia_Ecommerce.product.service.interfaces.ProductService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class ProductServiceIMPL implements ProductService {
    private final ProductRepository productRepository;
    @Override
    public ProductResponse mapToProductResponse(Product product) {
        return ProductResponse.builder()
                .productName(product.getProductName())
                .productPrice(product.getProductPrice())
                .category(product.getCategory())
                .createdAt(product.getCreatedAt())
                .build();
    }

    @Override
    public List<ProductResponse> getAllProductByWareHouseName(String wareHouseName) {
        List<Product> listOfProduct = productRepository.findByWareHouseNameOrderByCategory(wareHouseName);

        return listOfProduct.stream()
                .map(this::mapToProductResponse)
                .collect(Collectors.toList());
    }

    @Override
    public Product saveProduct(Product product) {
     return    productRepository.save(product);
    }


    @Override
    public Product findProductByProductName(String productName) {
        Product foundProduct = productRepository.findByProductName(productName);
        if (foundProduct == null)throw new ProductException("counld'nt find product with the name >>>>  "+productName);
        return foundProduct;
    }
}
