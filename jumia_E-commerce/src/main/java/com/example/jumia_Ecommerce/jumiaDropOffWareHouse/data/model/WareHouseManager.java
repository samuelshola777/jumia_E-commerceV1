package com.example.jumia_Ecommerce.jumiaDropOffWareHouse.data.model;

import com.example.jumia_Ecommerce.jumiaUser.data.model.JumiaUser;
import jakarta.persistence.*;

@Entity
public class WareHouseManager {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToOne(orphanRemoval = true, cascade = CascadeType.ALL)
    private JumiaUser jumiaUser;

    @OneToOne(orphanRemoval = true, cascade = CascadeType.ALL)
    private WareHouse warehouse;
}
