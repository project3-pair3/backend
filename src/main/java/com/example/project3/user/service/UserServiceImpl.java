package com.example.project3.user.service;

import com.example.project3.user.domain.User;
import com.example.project3.user.dto.UserLoginRequest;
import com.example.project3.user.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    UserRepository userRepository;

    UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(UserLoginRequest request) {
        User user = User.builder()
                .userId(request.getUserId())
                .password(request.getPassword())
                .nickname(request.getNickname())
                .build();

        return userRepository.save(user);
    }
}
