package com.example.jumia_Ecommerce.productSuppllier.data.model;

import com.example.jumia_Ecommerce.model.data.JumiaUser;
import com.example.jumia_Ecommerce.model.data.Role;
import jakarta.persistence.*;

public class ProductSupplier extends JumiaUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private boolean enabled;
    @Enumerated(EnumType.STRING)
    private Role role;
}
