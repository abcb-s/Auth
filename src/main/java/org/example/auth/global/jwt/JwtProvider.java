package org.example.auth.global.jwt;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@Component
@RequiredArgsConstructor
public class JwtProvider {

    private JwtProperties jwt;

    public String generateAccessToken(String username, String password){
        Instant now = Instant.now();
        return Jwts.builder()
                .header()
                .type("JWT")
                .and()
                .subject(username)
                .issuedAt(Date.from(now))
                .expiration(Date.from(now.plus(jwt.getExpiration(), ChronoUnit.MILLIS)))
                .compact();
    }
}
