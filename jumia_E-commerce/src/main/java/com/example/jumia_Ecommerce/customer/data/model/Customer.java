package com.example.jumia_Ecommerce.customer.data.model;

import com.example.jumia_Ecommerce.cart.data.model.Cart;
import com.example.jumia_Ecommerce.model.data.JumiaUser;
import com.example.jumia_Ecommerce.model.data.Role;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
public class Customer extends JumiaUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToOne(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Cart cart;
    @CreationTimestamp
    private LocalDateTime createdAt;
    private boolean enabled;
    @Enumerated(EnumType.STRING)
    private Role role;
//    @OneToOne(mappedBy = "customer", cascade = CascadeType.ALL)
//    private Address address;
}
