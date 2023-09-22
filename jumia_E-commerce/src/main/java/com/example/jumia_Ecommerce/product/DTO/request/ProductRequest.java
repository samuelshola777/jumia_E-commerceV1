package com.example.jumia_Ecommerce.product.DTO.request;

import com.example.jumia_Ecommerce.jumiaDropOffWareHouse.data.model.WareHouse;
import com.example.jumia_Ecommerce.generalEnums.Product_Categories;
import com.example.jumia_Ecommerce.productSuppllier.data.model.ProductSupplier;
import lombok.Data;

import java.math.BigDecimal;
@Data
public class ProductRequest {
    private String productName;

    private BigDecimal productPrice;
    private Product_Categories category;
    private String wareHouseName;
    private long quantity;
    private String productSupplierName;

    private ProductSupplier productSupplier;

    private WareHouse wareHouse;
}
