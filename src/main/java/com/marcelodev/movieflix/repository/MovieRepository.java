package com.marcelodev.movieflix.repository;

import com.marcelodev.movieflix.entity.Category;
import com.marcelodev.movieflix.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

   List<Movie> findMovieByCategories(List<Category> categories);

}
