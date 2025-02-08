package com.marcelodev.movieflix.mapper;

import com.marcelodev.movieflix.controller.request.MovieRequest;
import com.marcelodev.movieflix.controller.response.MovieResponse;
import com.marcelodev.movieflix.entity.Movie;
import lombok.experimental.UtilityClass;

@UtilityClass
public class MovieMapper {

    public static Movie toMovie(MovieRequest movieRequest) {
        return Movie
                .builder()
                .title(movieRequest.title())
                .description(movieRequest.description())
                .releaseDate(movieRequest.releaseDate())
                .rating(movieRequest.rating())
                .createdAt(movieRequest.createdAt())
                .updateAt(movieRequest.updateAt())
                .build();
    }

    public static MovieResponse toMovieResponse(Movie movie) {
        return MovieResponse
                .builder()
                .id(movie.getId())
                .title(movie.getTitle())
                .description(movie.getDescription())
                .releaseDate(movie.getReleaseDate())
                .rating(movie.getRating())
                .createdAt(movie.getCreatedAt())
                .updateAt(movie.getUpdateAt())
                .build();
    }

}
