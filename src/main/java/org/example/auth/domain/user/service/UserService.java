package org.example.auth.domain.user.service;

import org.example.auth.domain.user.dto.request.SignInUserRequest;
import org.example.auth.domain.user.dto.request.SignupUserRequest;
import org.example.auth.domain.user.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    void signUp(SignupUserRequest request);

    void SignIn(SignInUserRequest request);
}
