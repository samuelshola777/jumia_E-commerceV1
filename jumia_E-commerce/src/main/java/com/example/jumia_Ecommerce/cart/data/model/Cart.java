package com.example.jumia_Ecommerce.cart.data.model;

import com.example.jumia_Ecommerce.customer.data.model.Customer;
import com.example.jumia_Ecommerce.product.data.model.Product;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customer;
    @CreationTimestamp
    private LocalDateTime createdAt;
    @OneToMany(mappedBy = "chart_id", cascade = CascadeType.ALL, orphanRemoval = true)
    private final List<Product> listOfProducts = new ArrayList<>();
}
