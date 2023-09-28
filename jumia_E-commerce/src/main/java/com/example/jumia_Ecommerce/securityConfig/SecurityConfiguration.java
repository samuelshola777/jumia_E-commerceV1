package com.example.jumia_Ecommerce.securityConfig;

import com.example.jumia_Ecommerce.securityConfig.endPoints.AccessAbleEndPoints;
import com.example.jumia_Ecommerce.securityConfig.endPoints.NonAccessAbleEndpoints;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {
    private final JWTAuthenticationFilter jwtAuthFilter;
    private final AuthenticationProvider authenticationProvider;


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
       httpSecurity.csrf(AbstractHttpConfigurer::disable)
       .authorizeHttpRequests(accessEndPoint -> accessEndPoint .requestMatchers(AccessAbleEndPoints.whiteLabelEndPoints()).permitAll())
       .authorizeHttpRequests(nonAccessEndPoint -> nonAccessEndPoint .requestMatchers(NonAccessAbleEndpoints.blackLabelEndPoints()).authenticated())
       .authorizeHttpRequests(anyRequest -> anyRequest.anyRequest().authenticated())
       .sessionManagement(sec -> sec.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
       .authenticationProvider(authenticationProvider )
       .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);
       return httpSecurity.build();
    }
}
