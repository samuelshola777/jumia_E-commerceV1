package com.example.jumia_Ecommerce.customer.data.model;

import com.example.jumia_Ecommerce.cart.data.model.Cart;
import com.example.jumia_Ecommerce.jumiaUser.data.model.JumiaUser;
import com.example.jumia_Ecommerce.model.data.Role;
import jakarta.persistence.*;

@Entity
public class Customer  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToOne
    private Cart cart;
    private boolean enabled;
    @Enumerated(EnumType.STRING)
    private Role role = Role.CUSTOMER;
    @OneToOne(cascade = CascadeType.ALL)
    private JumiaUser user;
}
