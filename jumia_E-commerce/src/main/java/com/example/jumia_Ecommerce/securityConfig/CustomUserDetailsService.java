package com.example.jumia_Ecommerce.securityConfig;

import com.example.jumia_Ecommerce.jumiaDropOffWareHouse.data.model.WareHouse;
import com.example.jumia_Ecommerce.jumiaDropOffWareHouse.data.repository.WareHouseRepository;
import com.example.jumia_Ecommerce.jumiaDropOffWareHouse.exception.WareHouseLoginException;
import com.example.jumia_Ecommerce.jumiaUser.data.model.JumiaUser;
import com.example.jumia_Ecommerce.jumiaUser.data.repository.JumiaUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;



@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
        private final JumiaUserRepository jumiaUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        JumiaUser foundJumiaUser = jumiaUserRepository.findJumiaUserByUserName(username);
        if (foundJumiaUser == null) throw new WareHouseLoginException(" security couldn't find ware house with the name -> " + username+" <-");
        return new User(foundJumiaUser.getUserName(), foundJumiaUser.getPassword(), List.of(new SimpleGrantedAuthority(foundJumiaUser.getRole().name())));
    }

}
