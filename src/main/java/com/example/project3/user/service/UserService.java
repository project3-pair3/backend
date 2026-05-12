package com.example.project3.user.service;

import com.example.project3.user.domain.User;
import com.example.project3.user.dto.UserLoginRequest;
import com.example.project3.user.dto.UserSignupRequest;

public interface UserService {
    User createUser(UserSignupRequest request);

    User loginUser(UserLoginRequest request);
}
