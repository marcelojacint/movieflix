package com.marcelodev.movieflix.controller;

import com.marcelodev.movieflix.controller.request.MovieRequest;
import com.marcelodev.movieflix.controller.response.MovieResponse;
import com.marcelodev.movieflix.entity.Movie;
import com.marcelodev.movieflix.mapper.MovieMapper;
import com.marcelodev.movieflix.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")
    public ResponseEntity<MovieResponse> findById(@PathVariable Long id) {
      return movieService.findById(id)
              .map(movie -> ResponseEntity.ok(MovieMapper.toMovieResponse(movie)))
              .orElse(ResponseEntity.notFound().build());
    }

   @PostMapping
    public ResponseEntity<MovieResponse> save(@RequestBody MovieRequest movieRequest) {
       MovieResponse movieResponse = MovieMapper.toMovieResponse(movieService.save(MovieMapper.toMovie(movieRequest)));
       return ResponseEntity.status(HttpStatus.CREATED).body(movieResponse);
   }

   @PutMapping("/{id}")
    public ResponseEntity<MovieResponse> update(@PathVariable Long id, @RequestBody MovieRequest movieRequest) {
       MovieResponse movieResponse = MovieMapper.toMovieResponse(movieService.update(id, MovieMapper.toMovie(movieRequest)));
       return ResponseEntity.ok(movieResponse);
   }
}
