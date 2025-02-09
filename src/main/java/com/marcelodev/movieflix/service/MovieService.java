package com.marcelodev.movieflix.service;

import com.marcelodev.movieflix.entity.Movie;
import com.marcelodev.movieflix.exception.MovieException;
import com.marcelodev.movieflix.exception.StreamingException;
import com.marcelodev.movieflix.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class MovieService {

    private MovieRepository movieRepository;

    public List<Movie> findAll() {
        if (movieRepository.findAll().isEmpty()) {
            throw new MovieException("No movies found");
        }
        return movieRepository.findAll();
    }

    public Optional<Movie> findById(Long id) {
        if (!movieRepository.existsById(id)) {
            throw new MovieException("Movie not found");
        }
        return movieRepository.findById(id);
    }

    public Movie save(Movie movie) {
        if (!movieRepository.existsById(movie.getId())) {
            throw new MovieException("Movie not found");
        }
        return movieRepository.save(movie);
    }

    public Movie update(Long id, Movie movie) {
        Optional<Movie> optMovie = movieRepository.findById(id);
        return optMovie.map(existingMovie -> {
                    existingMovie.setTitle(movie.getTitle());
                    existingMovie.setDescription(movie.getDescription());
                    existingMovie.setReleaseDate(movie.getReleaseDate());
                    existingMovie.setRating(movie.getRating());
                    return movieRepository.save(existingMovie);
                })
                .orElseThrow(() -> new MovieException("Movie not found"));
    }

}
