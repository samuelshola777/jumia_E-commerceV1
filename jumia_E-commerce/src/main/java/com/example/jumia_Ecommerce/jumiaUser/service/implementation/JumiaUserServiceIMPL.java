package com.example.jumia_Ecommerce.jumiaUser.service.implementation;

import com.example.jumia_Ecommerce.jumiaUser.DTO.request.JumiaUserRequest;
import com.example.jumia_Ecommerce.jumiaUser.data.model.JumiaUser;
import com.example.jumia_Ecommerce.jumiaUser.data.repository.JumiaUserRepository;
import com.example.jumia_Ecommerce.model.data.Address;
import com.example.jumia_Ecommerce.productSuppllier.DTO.request.ProductSupplierRequest;
import com.example.jumia_Ecommerce.jumiaUser.service.interfaces.JumiaUserService;
import com.example.jumia_Ecommerce.service.implementation.Tools;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class JumiaUserServiceIMPL implements JumiaUserService {
    private final Tools tools;
    private final JumiaUserRepository jumiaUserRepository;

    @Override
    public JumiaUser registerNewJumiaUser(JumiaUserRequest jumiaUserRequest) {
        tools.passwordValidate(jumiaUserRequest.getPassword());
        if (jumiaUserRepository.existsByEmailAddress(jumiaUserRequest.getEmailAddress())) throw new Reg
        JumiaUser builderJumiaUser = mapToJumiaUser(jumiaUserRequest);

        return null;
    }

    public JumiaUser mapToJumiaUser(JumiaUserRequest jumiaUserRequest){
        return JumiaUser.builder()
                .userName(jumiaUserRequest.getUserName())
                .emailAddress(jumiaUserRequest.getEmailAddress())
                .phoneNumber(jumiaUserRequest.getPhoneNumber())
                .password(jumiaUserRequest.getPassword())
                .mobileNetwork(jumiaUserRequest.getMobileNetwork())
                .address(jumiaUserRequest.getAddress())
                .build();
    }
}
