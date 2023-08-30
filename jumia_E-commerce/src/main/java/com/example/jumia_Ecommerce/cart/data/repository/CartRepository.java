package com.example.jumia_Ecommerce.cart.data.repository;

import com.example.jumia_Ecommerce.cart.data.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {
}
