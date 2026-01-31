package org.example.auth.domain.user.dto.request;

import jakarta.validation.constraints.NotBlank;

public record SignupUserRequest(
        @NotBlank String username,
        @NotBlank String password,
        @NotBlank String email
) {
}
