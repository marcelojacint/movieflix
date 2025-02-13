package com.marcelodev.movieflix.controller;

import com.marcelodev.movieflix.controller.request.UserRequest;
import com.marcelodev.movieflix.controller.response.UserResponse;
import com.marcelodev.movieflix.mapper.UserMapper;
import com.marcelodev.movieflix.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/movieflix/auth")
public class AuthController {

    private UserService userService;

    @PostMapping
    public ResponseEntity<UserResponse> register(@RequestBody UserRequest request) {

        return ResponseEntity
                .status(HttpStatus.CREATED).body(UserMapper.toUserResponse(userService.save(UserMapper.toUser(request))));

    }
}
