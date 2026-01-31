package org.example.auth.domain.user.dto.request;

import jakarta.validation.constraints.NotBlank;

public record SignInUserRequest(
        @NotBlank String username,
        @NotBlank String password
) {
}
