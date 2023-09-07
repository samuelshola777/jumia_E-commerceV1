package com.example.jumia_Ecommerce.jumiaUser.DTO.request;

import com.example.jumia_Ecommerce.model.data.Address;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class JumiaUserRequest {
    private String userName;

    private String password;

    private String phoneNumber;

    private String emailAddress;

    private String mobileNetwork;

    private Address address;
}
