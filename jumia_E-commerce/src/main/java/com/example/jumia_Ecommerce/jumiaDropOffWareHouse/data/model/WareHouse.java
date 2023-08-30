package com.example.jumia_Ecommerce.jumiaDropOffWareHouse.data.model;

import com.example.jumia_Ecommerce.model.data.Address;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

public class WareHouse {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private long id;
    @OneToOne
    private Address address;

}
