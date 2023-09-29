package com.example.jumia_Ecommerce.jumiaDropOffWareHouse.data.model;

import com.example.jumia_Ecommerce.model.data.Address;
import com.example.jumia_Ecommerce.generalEnums.AvailabilityState;
import com.example.jumia_Ecommerce.product.data.model.Product;
import jakarta.persistence.*;
import jdk.jfr.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WareHouse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;
    @OneToOne(orphanRemoval = true)
    private Address wareHouesAddress;
    private boolean loggedIn;
    private String wareHouseName;
    @Timestamp
    private LocalDateTime createAt;
    @Timestamp
    private LocalDateTime lastUpdated;
    private String password;
    @Enumerated(EnumType.STRING)
    private AvailabilityState currentState;
    private String wareHouseManagerEmail;
        @OneToMany(mappedBy = "wareHouse", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Product> listOfProducts = new ArrayList<>();



}
