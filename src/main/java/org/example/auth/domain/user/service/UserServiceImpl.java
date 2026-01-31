package org.example.auth.domain.user.service;

import lombok.AllArgsConstructor;
import org.example.auth.domain.user.dto.request.SignInUserRequest;
import org.example.auth.domain.user.dto.request.SignupUserRequest;
import org.example.auth.domain.user.entity.Role;
import org.example.auth.domain.user.entity.User;
import org.example.auth.domain.user.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public void signUp(SignupUserRequest request){

        if(userRepository.findByUsername(request.username()).isPresent()){
            throw new IllegalArgumentException("이미 사용중인 아이디입니다.");
        }

        if (userRepository.findByEmail(request.email()).isPresent()){
            throw new IllegalArgumentException("이미 사용중인 이메일입니다.");
        }

        User user = User.builder()
                .username(request.username())
                .password(passwordEncoder.encode(request.password()))
                .email(request.email())
                .role(Role.USER)
                .build();
    }

    @Override
    public void SignIn(SignInUserRequest request){
       User user = userRepository.findByUsername(request.username())
               .orElseThrow(() -> new IllegalArgumentException("없는 아이디입니다."));

       if(!passwordEncoder.matches(request.password(), user.getPassword())){
           throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
       }


    }
}
