package com.example.project3.user.service;

import com.example.project3.user.domain.User;
import com.example.project3.user.dto.UserLoginRequest;

public interface UserService {
    User createUser(UserLoginRequest request);
}
