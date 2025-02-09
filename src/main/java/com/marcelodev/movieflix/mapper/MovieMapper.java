package com.marcelodev.movieflix.mapper;

import com.marcelodev.movieflix.controller.request.MovieRequest;
import com.marcelodev.movieflix.controller.response.CategoryResponse;
import com.marcelodev.movieflix.controller.response.MovieResponse;
import com.marcelodev.movieflix.controller.response.StreamingResponse;
import com.marcelodev.movieflix.entity.Category;
import com.marcelodev.movieflix.entity.Movie;
import com.marcelodev.movieflix.entity.Streaming;
import lombok.experimental.UtilityClass;

import java.util.List;

@UtilityClass
public class MovieMapper {

    public static Movie toMovie(MovieRequest movieRequest) {
        List<Category> categories = movieRequest.categories()
                .stream()
                .map(categoryId -> Category.builder().id(categoryId).build()).toList();

        List<Streaming> streamings = movieRequest.Streamings()
                .stream()
                .map(streamingId -> Streaming.builder().id(streamingId).build()).toList();

        return Movie
                .builder()
                .title(movieRequest.title())
                .description(movieRequest.description())
                .releaseDate(movieRequest.releaseDate())
                .rating(movieRequest.rating())
                .categories(categories)
                .streamings(streamings)
                .build();
    }

    public static MovieResponse toMovieResponse(Movie movie) {
        List<CategoryResponse> categoryResponses = movie.getCategories()
                .stream()
                .map(CategoryMapper::toCategoryResponse).toList();

        List<StreamingResponse> streamingResponses = movie.getStreamings()
                .stream()
                .map(StreamingMapper::toStreamingResponse).toList();

        return MovieResponse
                .builder()
                .id(movie.getId())
                .title(movie.getTitle())
                .description(movie.getDescription())
                .releaseDate(movie.getReleaseDate())
                .rating(movie.getRating())
                .categories(categoryResponses)
                .streamings(streamingResponses)
                .build();
    }

}
