package com.example.project3.user.dto;

import lombok.Getter;

@Getter
public class UserLoginRequest {
    String userId;
    String password;
    String nickname;
}
