package com.example.jumia_Ecommerce.model.data;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String buildingNumber;
    @Column(nullable = false)
    private String streetName;
    private String locationGovernmentName;
    private String state;

//    @OneToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "customer_id")
//     private Customer customer;
}
