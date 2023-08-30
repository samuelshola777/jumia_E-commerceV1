package com.example.jumia_Ecommerce.product.data.model;

import com.example.jumia_Ecommerce.cart.data.model.Cart;
import com.example.jumia_Ecommerce.jumiaDropOffWareHouse.data.model.WareHouse;
import com.example.jumia_Ecommerce.model.data.Categories;
import com.example.jumia_Ecommerce.productSuppllier.data.model.ProductSupplier;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;
    @Column(nullable = false)
    private String productName;
    @Column(nullable = false)
    private BigDecimal productPrice;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    @Enumerated(EnumType.STRING)
    private Categories category;
    private long quantity;

    @JoinColumn(name = "supplier_id", nullable = false)
    @ManyToOne
    private ProductSupplier productSupplier;
    @ManyToOne
    @JoinColumn(name = "wareHouse_id", nullable = false)
    private WareHouse wareHouse;
}
