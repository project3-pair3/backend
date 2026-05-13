package com.example.project3.user.controller;

import com.example.project3.user.domain.User;
import com.example.project3.user.dto.UserLoginRequest;
import com.example.project3.user.dto.UserSignupRequest;
import com.example.project3.user.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    UserService userService;

    UserController(UserService userService){
        this.userService = userService;
    }

    @Operation(summary = "회원가입", description = "[회원가입 페이지] 유저 정보를 생성합니다. (평문 저장!!)")
    @PostMapping("/join")
    ResponseEntity<User> createUser(@RequestBody UserSignupRequest request) {
        User newUser = userService.createUser(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
    }

    @Operation(summary = "로그인", description = "[로그인 페이지] 로그인 정보를 요청하면 아이디/비밀번호 일치 여부를 반환합니다.")
    @PostMapping("/login")
    ResponseEntity<User> loginUser(@RequestBody UserLoginRequest request){
        User loginUser = userService.loginUser(request);

        return ResponseEntity.ok(loginUser);
    }
}
