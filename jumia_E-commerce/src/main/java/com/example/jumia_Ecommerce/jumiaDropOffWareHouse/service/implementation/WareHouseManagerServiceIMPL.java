package com.example.jumia_Ecommerce.jumiaDropOffWareHouse.service.implementation;

import com.example.jumia_Ecommerce.generalEnums.Role;
import com.example.jumia_Ecommerce.jumiaDropOffWareHouse.data.model.WareHouseManager;
import com.example.jumia_Ecommerce.jumiaDropOffWareHouse.data.repository.WareHouseManagerRepository;
import com.example.jumia_Ecommerce.jumiaDropOffWareHouse.service.interfaces.WareHouseManagerService;
import com.example.jumia_Ecommerce.jumiaDropOffWareHouse.service.interfaces.WareHouseService;
import com.example.jumia_Ecommerce.jumiaUser.DTO.request.JumiaUserRequest;
import com.example.jumia_Ecommerce.jumiaUser.data.model.JumiaUser;
import com.example.jumia_Ecommerce.jumiaUser.exception.JumiaUserException;
import com.example.jumia_Ecommerce.jumiaUser.service.interfaces.JumiaUserService;
import com.example.jumia_Ecommerce.securityConfig.JWTService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class WareHouseManagerServiceIMPL implements WareHouseManagerService {
    private final JumiaUserService jumiaUserService;
    private final WareHouseManagerRepository wareHouseManagerRepo;
    private final WareHouseService wareHouseService;
    private final AuthenticationManager authenticationManager;
    private final JWTService jwtService;
    @Override
    public String registerNewWareHouse(JumiaUserRequest jumiaUserRequest,  String wareHouseName) {
    jumiaUserRequest.setRole(Role.WARE_HOUSE_MANAGER);
       JumiaUser createdJumiaUser = jumiaUserService.registerNewJumiaUser(jumiaUserRequest);
        wareHouseManagerRepo.save(
    WareHouseManager.builder()
            .warehouse(wareHouseService.findWareHouseByName(wareHouseName))
            .jumiaUser(createdJumiaUser)
            .wareHouseName(wareHouseName)
            .registrationDate(LocalDateTime.now())
            .build()
        );
        return jwtService.generateToken(createdJumiaUser);
    }
    @Override
    public String loginAsWareHouseManager(String email, String password) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
        } catch (Exception e) {
            throw new JumiaUserException("login authentication could not be completed  -> " + e.getMessage());
        }
        return jwtService.generateToken(jumiaUserService.findJumiaUserByEmail(email));
    }

    @Override
    public void deleteAllWareHouseManager() {
        wareHouseManagerRepo.deleteAll();
    }


}
