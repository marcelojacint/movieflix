package com.marcelodev.movieflix.controller;

import com.marcelodev.movieflix.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/movieflix/auth")
public class AuthController {

    private UserService userService;
}
