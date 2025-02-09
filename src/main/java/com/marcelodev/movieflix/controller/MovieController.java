package com.marcelodev.movieflix.controller;

import com.marcelodev.movieflix.controller.response.MovieResponse;
import com.marcelodev.movieflix.mapper.MovieMapper;
import com.marcelodev.movieflix.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/movieflix/movie")
public class MovieController {

    private final MovieService movieService;

    @GetMapping
    public ResponseEntity<List<MovieResponse>> findAll() {
        List<MovieResponse> movieResponses = movieService.findAll()
                .stream()
                .map(MovieMapper::toMovieResponse).toList();
        return ResponseEntity.ok(movieResponses);
    }
}
