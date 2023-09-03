package com.example.jumia_Ecommerce.product.DTO.response;

import com.example.jumia_Ecommerce.model.data.Categories;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class ProductResponse {
    private String productName;
    private BigDecimal productPrice;
    private LocalDateTime createdAt;
    @Enumerated(EnumType.STRING)
    private Categories category;
}
