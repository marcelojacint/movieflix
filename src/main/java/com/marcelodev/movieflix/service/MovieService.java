package com.marcelodev.movieflix.service;

import com.marcelodev.movieflix.entity.Movie;
import com.marcelodev.movieflix.exception.StreamingException;
import com.marcelodev.movieflix.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class MovieService {

    private MovieRepository movieRepository;

    public List<Movie> findAll() {
        if(movieRepository.findAll().isEmpty()) {
            throw new StreamingException("No movies found");
        }
        return movieRepository.findAll();
    }

}
