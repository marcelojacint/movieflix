package com.marcelodev.movieflix.service;

import com.marcelodev.movieflix.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MovieService {

    private MovieRepository movieRepository;

}
