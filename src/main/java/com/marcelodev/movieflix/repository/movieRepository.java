package com.marcelodev.movieflix.repository;

import com.marcelodev.movieflix.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface movieRepository extends JpaRepository<Movie, Long> {

}
