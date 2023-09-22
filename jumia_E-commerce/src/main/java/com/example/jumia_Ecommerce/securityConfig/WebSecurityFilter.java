package com.example.jumia_Ecommerce.securityConfig;

import com.example.jumia_Ecommerce.securityConfig.endPoints.AccessAbleEndPoints;
import com.example.jumia_Ecommerce.securityConfig.endPoints.NonAccessAbleEndpoints;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration

public class WebSecurityFilter {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(locked -> locked.requestMatchers(NonAccessAbleEndpoints.blackLabelEndPoints()).authenticated())
                .authorizeHttpRequests(open -> open.requestMatchers(AccessAbleEndPoints.whiteLabelEndPoints()))
                .sessionManagement(sess-> sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .
    }

}
