package com.example.jumia_Ecommerce.jumiaUser.service.implementation;

import com.example.jumia_Ecommerce.exception.RegistrationException;
import com.example.jumia_Ecommerce.jumiaUser.DTO.request.JumiaUserRequest;
import com.example.jumia_Ecommerce.jumiaUser.DTO.request.UpdateJumiaUserRequest;
import com.example.jumia_Ecommerce.jumiaUser.DTO.response.JumiaUserResponse;
import com.example.jumia_Ecommerce.jumiaUser.data.model.JumiaUser;
import com.example.jumia_Ecommerce.jumiaUser.data.repository.JumiaUserRepository;
import com.example.jumia_Ecommerce.jumiaUser.exception.JumiaUserException;
import com.example.jumia_Ecommerce.model.data.Address;
import com.example.jumia_Ecommerce.productSuppllier.DTO.request.ProductSupplierRequest;
import com.example.jumia_Ecommerce.jumiaUser.service.interfaces.JumiaUserService;
import com.example.jumia_Ecommerce.service.implementation.Tools;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class JumiaUserServiceIMPL implements JumiaUserService {
    private final JumiaUserRepository jumiaUserRepository;
    private final Tools tools;
  private final PasswordEncoder password;


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
    public boolean ifExistByEmail(String email) {
        if (jumiaUserRepository.existsByEmailAddress(email)) return true;
        return false;
    }

    @Override
    public boolean ifExistByUsername(String username) {
        if (jumiaUserRepository.existsByUserName(username)) return true;
        return false;
    }

    @Override
    public JumiaUser findJumiaUserByUsername(String username) {
        JumiaUser foundJumiaUser = jumiaUserRepository.findJumiaUserByUserName(username);
        if (foundJumiaUser == null) throw new RegistrationException("Could not find Jumia user by username  " + username);
        return foundJumiaUser;
    }

    @Override
    public JumiaUser findJumiaUserByEmail(String email) {
        JumiaUser foundJumiaUser = jumiaUserRepository.findJumiaUserByEmailAddress(email);
        if (foundJumiaUser == null) throw new RegistrationException("Could not find Jumia user by username  " +email);
        return foundJumiaUser;
    }

    @Override
    public JumiaUser updateJumiaUser( UpdateJumiaUserRequest jumiaUserRequest) {
        JumiaUser foundUser = findJumiaUserByUsername(jumiaUserRequest.getJumiaUserUserName());
        if (foundUser != null) {
            foundUser = findJumiaUserByUserEmail(jumiaUserRequest.getJumiaUserEmailAddress());}
        if (foundUser != null) throw new JumiaUserException("User with the email address -> "+
        jumiaUserRequest.getJumiaUserEmailAddress()+"  "+jumiaUserRequest.getJumiaUserUserName()+" does not exist");
            if (jumiaUserRequest.getUserName() != null) foundUser.setUserName(jumiaUserRequest.getUserName());
            if (jumiaUserRequest.getPassword() != null) foundUser.setPassword(jumiaUserRequest.getPassword());
            if (jumiaUserRequest.getPhoneNumber() != null) foundUser.setPhoneNumber(jumiaUserRequest.getPhoneNumber());
            if (jumiaUserRequest.getEmailAddress() != null) foundUser.setEmailAddress(jumiaUserRequest.getEmailAddress());
            if (jumiaUserRequest.getAddress().getStreetName() != null)
                foundUser.getAddress().setStreetName(jumiaUserRequest.getAddress().getStreetName());
            if (jumiaUserRequest.getAddress().getLocationGovernmentName() != null)
                foundUser.getAddress().setLocationGovernmentName(jumiaUserRequest.getAddress().getLocationGovernmentName());
            if (jumiaUserRequest.getAddress().getState() != null)
                foundUser.getAddress().setState(jumiaUserRequest.getAddress().getState());
            if (jumiaUserRequest.getAddress().getBuildingNumber() != null)
                foundUser.getAddress().setBuildingNumber(jumiaUserRequest.getAddress().getBuildingNumber());

    return jumiaUserRepository.save(foundUser);
    }

    public JumiaUser findJumiaUserByUserEmail(String jumiaUserEmailAddress) {
        JumiaUser foundJumiaUser = jumiaUserRepository.findByEmailAddress(jumiaUserEmailAddress);
        if (foundJumiaUser == null) throw new RegistrationException("Could not find Jumia user by username  " + jumiaUserEmailAddress);
        return foundJumiaUser;
    }

    public JumiaUser mapToJumiaUser(JumiaUserRequest jumiaUserRequest){
        return JumiaUser.builder()
                .mobileNetwork(tools.networkProvider(jumiaUserRequest.getPhoneNumber()))
                .userName(jumiaUserRequest.getUserName())
                .emailAddress(jumiaUserRequest.getEmailAddress())
                .phoneNumber(jumiaUserRequest.getPhoneNumber())
                .role(jumiaUserRequest.getRole())
                .password(jumiaUserRequest.getPassword())
                .password(password.encode(jumiaUserRequest.getPassword()))
                .mobileNetwork(tools.networkProvider(jumiaUserRequest.getPhoneNumber()))
                .address(jumiaUserRequest.getAddress())
                .build();
    }

}
