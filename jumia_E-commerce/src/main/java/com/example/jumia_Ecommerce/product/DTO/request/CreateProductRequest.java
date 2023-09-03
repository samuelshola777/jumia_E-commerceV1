package com.example.jumia_Ecommerce.product.DTO.request;

import com.example.jumia_Ecommerce.jumiaDropOffWareHouse.data.model.WareHouse;
import com.example.jumia_Ecommerce.model.data.Categories;
import com.example.jumia_Ecommerce.product.data.model.ProductState;
import com.example.jumia_Ecommerce.productSuppllier.data.model.ProductSupplier;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class CreateProductRequest {
    private ProductSupplier productSupplier;
    private String productName;
    private BigDecimal productPrice;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Categories category;
    private long quantity;
    private ProductState productState;
    private WareHouse wareHouse;
}
