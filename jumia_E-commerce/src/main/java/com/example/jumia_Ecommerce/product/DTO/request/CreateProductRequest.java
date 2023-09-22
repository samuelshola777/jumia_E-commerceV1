package com.example.jumia_Ecommerce.product.DTO.request;

import com.example.jumia_Ecommerce.jumiaDropOffWareHouse.data.model.WareHouse;
import com.example.jumia_Ecommerce.generalEnums.Product_Categories;
import com.example.jumia_Ecommerce.product.data.model.ProductState;
import com.example.jumia_Ecommerce.productSuppllier.data.model.ProductSupplier;
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
    private Product_Categories category;
    private long quantity;
    private ProductState productState;
    private WareHouse wareHouse;
}
