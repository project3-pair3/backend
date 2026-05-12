package com.example.project3.user.controller;

import com.example.project3.user.domain.User;
import com.example.project3.user.dto.UserLoginRequest;
import com.example.project3.user.dto.UserSignupRequest;
import com.example.project3.user.service.UserService;
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

    @PostMapping("/join")
    ResponseEntity<User> createUser(@RequestBody UserSignupRequest request) {
        User newUser = userService.createUser(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
    }

    @PostMapping("/login")
    ResponseEntity<User> loginUser(@RequestBody UserLoginRequest request){
        User loginUser = userService.loginUser(request);

        return ResponseEntity.ok(loginUser);
    }
}
