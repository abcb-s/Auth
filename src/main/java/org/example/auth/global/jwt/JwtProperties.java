package org.example.auth.global.jwt;


import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;


@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "application.jwt")
public class JwtProperties {

    private long expiration;
    private long refreshExpiration;
}
