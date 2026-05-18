package com.example.project3.user.service;

import com.example.project3.user.domain.User;
import com.example.project3.user.dto.UserLoginRequest;
import com.example.project3.user.dto.UserSignupRequest;
import com.example.project3.user.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    UserRepository userRepository;
    PasswordEncoder passwordEncoder;

    UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User createUser(UserSignupRequest request) {
        String password = passwordEncoder.encode(request.getPassword());
        User user = User.builder()
                .userId(request.getUserId())
                .password(password)
                .nickname(request.getNickname())
                .build();

        return userRepository.save(user);
    }

    public User loginUser(UserLoginRequest request) {
        // 아이디, 비밀번호 맞는지 여부 확인
        User user = userRepository.findByUserId(request.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 아이디입니다: " + request.getUserId()));

        if(!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }

        return user;
    }
}
