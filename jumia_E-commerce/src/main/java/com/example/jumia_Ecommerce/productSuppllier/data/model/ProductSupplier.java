package com.example.jumia_Ecommerce.productSuppllier.data.model;

import com.example.jumia_Ecommerce.jumiaUser.data.model.JumiaUser;
import com.example.jumia_Ecommerce.generalEnums.AvailabilityState;
import com.example.jumia_Ecommerce.generalEnums.Role;
import com.example.jumia_Ecommerce.model.data.Address;
import com.example.jumia_Ecommerce.product.data.model.Product;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductSupplier  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToOne(orphanRemoval = true, cascade = CascadeType.ALL)
    private JumiaUser jumiaUser;
    private boolean enabled;
    @OneToMany(mappedBy = "productSupplier", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private final List<Product> listOfProducts = new ArrayList<>();
    @Enumerated(EnumType.STRING)
    private AvailabilityState state = AvailabilityState.PENDING;

}
