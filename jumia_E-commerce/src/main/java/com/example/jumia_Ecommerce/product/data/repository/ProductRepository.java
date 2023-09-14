package com.example.jumia_Ecommerce.product.data.repository;

import com.example.jumia_Ecommerce.product.data.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByWareHouseNameOrderByCategory(String warehouse);

    Product findByProductName(String productName);
}
