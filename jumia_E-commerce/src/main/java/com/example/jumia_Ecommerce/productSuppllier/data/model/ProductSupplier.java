package com.example.jumia_Ecommerce.productSuppllier.data.model;

import com.example.jumia_Ecommerce.model.data.JumiaUser;
import com.example.jumia_Ecommerce.model.data.Role;
import com.example.jumia_Ecommerce.product.data.model.Product;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

public class ProductSupplier extends JumiaUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private boolean enabled;
    @Enumerated(EnumType.STRING)
    private Role role;
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private final List<Product> listOfProducts = new ArrayList<>();
}
