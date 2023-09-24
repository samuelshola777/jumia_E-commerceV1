package com.example.jumia_Ecommerce.jumiaDropOffWareHouse.data.model;

import com.example.jumia_Ecommerce.generalEnums.Role;
import com.example.jumia_Ecommerce.jumiaUser.data.model.JumiaUser;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class WareHouseManager {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToOne(orphanRemoval = true, cascade = CascadeType.ALL)
    private JumiaUser jumiaUser;

    @OneToOne(orphanRemoval = true, cascade = CascadeType.ALL)
    private WareHouse warehouse;
    private String wareHouseName;
    private LocalDateTime registrationDate;


}
