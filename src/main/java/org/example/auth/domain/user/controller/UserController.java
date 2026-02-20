package org.example.auth.domain.user.controller;

import lombok.RequiredArgsConstructor;
import org.example.auth.domain.user.dto.request.SignInUserRequest;
import org.example.auth.domain.user.dto.request.SignupUserRequest;
import org.example.auth.domain.user.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/sign-up")
    public ResponseEntity<?> signUp(@RequestBody SignupUserRequest request){
        userService.signUp(request);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/sign-in")
    public ResponseEntity<?> signIn(@RequestBody SignInUserRequest request){
        userService.SignIn(request);
        return ResponseEntity.ok().build();
    }
}
