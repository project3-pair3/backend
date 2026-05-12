package com.example.project3.user.dto;

import lombok.Getter;

@Getter
public class UserSignupRequest {
    String userId;
    String password;
    String nickname;
}
