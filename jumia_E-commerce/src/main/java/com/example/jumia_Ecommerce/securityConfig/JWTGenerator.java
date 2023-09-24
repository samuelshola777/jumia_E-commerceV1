package com.example.jumia_Ecommerce.securityConfig;

import com.example.jumia_Ecommerce.generalEnums.Role;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class JWTGenerator {
@Value("${JWT_SECRETS")
private  String JWT_SECRET_KEY;


    
    
    
    public String generateJWT(Authentication authentication){
        String authenticationName = authentication.getName();
        Date generatedDate = new Date();
        Date expiredDate = new Date(generatedDate.getTime() + 1000 * 3);

        return Jwts.builder().setSubject(authenticationName)
                .setIssuedAt(generatedDate)
                .setExpiration(expiredDate)
                .signWith(SignatureAlgorithm.HS512, JWT_SECRET_KEY)
                .compact();

    }

}
