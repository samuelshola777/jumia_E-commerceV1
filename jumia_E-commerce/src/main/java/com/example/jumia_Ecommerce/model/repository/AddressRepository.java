package com.example.jumia_Ecommerce.model.repository;

import com.example.jumia_Ecommerce.model.data.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
