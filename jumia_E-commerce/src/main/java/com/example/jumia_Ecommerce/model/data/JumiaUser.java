package com.example.jumia_Ecommerce.model.data;

import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public class JumiaUser {

    private String userName;
    private String password;
    private String phoneNumber;
    private String emailAddress;
    private String mobileNetwork;
    private Address address;

}
