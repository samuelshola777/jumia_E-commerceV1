package com.example.jumia_Ecommerce.securityConfig;

import com.example.jumia_Ecommerce.jumiaDropOffWareHouse.data.model.WareHouse;
import com.example.jumia_Ecommerce.jumiaDropOffWareHouse.data.repository.WareHouseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {


        private final WareHouseRepository wareHouseRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        WareHouse foundWare = wareHouseRepository.findByWareHouseName(username);
        return null;
    }
}
