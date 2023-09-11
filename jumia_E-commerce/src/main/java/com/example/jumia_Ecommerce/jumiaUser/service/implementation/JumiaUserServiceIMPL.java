package com.example.jumia_Ecommerce.jumiaUser.service.implementation;

import com.example.jumia_Ecommerce.exception.RegistrationException;
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

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class JumiaUserServiceIMPL implements JumiaUserService {
    private final JumiaUserRepository jumiaUserRepository;
    private final Tools tools;


    @Override
    public JumiaUser registerNewJumiaUser(JumiaUserRequest jumiaUserRequest) {
        tools.passwordValidate(jumiaUserRequest.getPassword());
        if (jumiaUserRepository.existsByEmailAddress(jumiaUserRequest.getEmailAddress()))
            throw new RegistrationException("email address  " + jumiaUserRequest.getEmailAddress()+"  already exists");
        if (jumiaUserRequest.getPhoneNumber().length() < 11 || jumiaUserRequest.getPhoneNumber().length() > 12 )
            throw new RegistrationException("phone number " + jumiaUserRequest.getPhoneNumber()+" is not  invalid");
        JumiaUser builderJumiaUser = mapToJumiaUser(jumiaUserRequest);
        return jumiaUserRepository.save(builderJumiaUser);
    }

    @Override
    public List<JumiaUser> findJumiaUserByUsername(String username) {
        return null;
    }

    public JumiaUser mapToJumiaUser(JumiaUserRequest jumiaUserRequest){
        return JumiaUser.builder()
                .mobileNetwork(tools.networkProvider(jumiaUserRequest.getPhoneNumber()))
                .userName(jumiaUserRequest.getUserName())
                .emailAddress(jumiaUserRequest.getEmailAddress())
                .phoneNumber(jumiaUserRequest.getPhoneNumber())
                .password(jumiaUserRequest.getPassword())
                .mobileNetwork(tools.networkProvider(jumiaUserRequest.getPhoneNumber()))
                .address(jumiaUserRequest.getAddress())
                .build();
    }
}
