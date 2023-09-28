package com.example.jumia_Ecommerce.securityConfig;

import com.example.jumia_Ecommerce.jumiaUser.data.repository.JumiaUserRepository;
import com.example.jumia_Ecommerce.jumiaUser.exception.JumiaUserException;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@RequiredArgsConstructor
public class SecurityConfigB {
    private final JumiaUserRepository jumiaUserRepository;
   // private final PasswordEncoder passwordEncoder;

    @Bean
    public UserDetailsService userDetailsService() {
            return jumiaUserRepository::findJumiaUserByEmailAddress;

    }
//    @Bean
//    public UserDetailsService userDetailsService() {
//        try {
//            return jumiaUserRepository::findJumiaUserByEmailAddress;
//        }catch (Exception e) {
//            throw new JumiaUserException("security couldn't find user  ->  "+e.getMessage());
//        }
//    }


    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService());
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
            return  authenticationConfiguration.getAuthenticationManager();

    }
//    @Bean
//    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration){
//        try{
//            return  authenticationConfiguration.getAuthenticationManager();
//        }catch (Exception e){
//            throw new JumiaUserException("security authentication manager couldn't perform authentication ->  "+e.getMessage());
//        }
//    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
