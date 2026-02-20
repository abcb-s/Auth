package org.example.auth.domain.user.service;

import org.example.auth.domain.user.dto.request.SignInUserRequest;
import org.example.auth.domain.user.dto.request.SignupUserRequest;
import org.example.auth.global.jwt.dto.TokenResponse;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    void signUp(SignupUserRequest request);

    TokenResponse SignIn(SignInUserRequest request);
}
