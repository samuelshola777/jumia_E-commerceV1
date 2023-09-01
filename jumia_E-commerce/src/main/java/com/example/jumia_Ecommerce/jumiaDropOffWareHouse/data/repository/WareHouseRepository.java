package com.example.jumia_Ecommerce.jumiaDropOffWareHouse.data.repository;

import com.example.jumia_Ecommerce.jumiaDropOffWareHouse.data.model.WareHouse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WareHouseRepository extends JpaRepository<WareHouse,Long> {
    boolean existsByWareHouseName(String streetName);

    WareHouse findByWareHouseName(String wareHouseName);
}
