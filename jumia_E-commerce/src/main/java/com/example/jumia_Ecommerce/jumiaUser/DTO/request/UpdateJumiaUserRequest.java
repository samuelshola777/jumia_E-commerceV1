package com.example.jumia_Ecommerce.jumiaUser.DTO.request;

import com.example.jumia_Ecommerce.model.data.Address;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UpdateJumiaUserRequest {

    private String JumiaUserEmailAddress;

    private String jumiaUserUserName;

    private String userName;

    private String password;

    private String phoneNumber;

    private String emailAddress;

    private Address address;
}
