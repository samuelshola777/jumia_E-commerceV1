package com.example.jumia_Ecommerce.jumiaUser.data.repository;

import com.example.jumia_Ecommerce.jumiaUser.data.model.JumiaUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JumiaUserRepository extends JpaRepository<JumiaUser, Long> {
    boolean existsByEmailAddress(String emailAddress);
}
