package com.example.jumia_Ecommerce.securityConfig;

import com.example.jumia_Ecommerce.generalEnums.Role;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.function.Function;

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

    public boolean validateToken(String token, UserDetails userDetails) {

      final String username = extractUsername(token);
      return (username.equals(userDetails.getUsername())) && !isTokenExpired(token);
    }

        private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private Date  extractExpiration(String token) {
return extractClaim(token, Claims::getExpiration);
    }

    private String extractUsername(String token) {
        return extractClaim(token, Claims ::getSubject);
    }

    private <T> T extractClaim(String token, Function<Claims, T> claimResolver) {
        final Claims claims = extractAllClaims(token);
        return claimResolver.apply(claims);
    }

    private Claims extractAllClaims(String token) {
            return Jwts.parserBuilder()
                    .setSigningKey(getSigningKey())
                    .build().parseClaimsJwt(token).getBody();
    }

    private Key getSigningKey() {
        byte[] KeyBytes = Decoders.BASE64.decode(JWT_SECRET_KEY);
            return Keys.hmacShaKeyFor(KeyBytes);
    }

    public String extractUserName(String token) {
        return extractClaim(token, Claims::getSubject);
    }
}
