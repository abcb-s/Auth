package org.example.auth.global.jwt.dto;

public record TokenResponse(
        String accessToken,
        String RefreshToken
) {
}
