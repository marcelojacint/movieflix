package com.marcelodev.movieflix.controller;

import com.marcelodev.movieflix.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/movieflix/movie")
public class MovieController {

    private final MovieService movieService;
}
