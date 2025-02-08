package com.marcelodev.movieflix.controller.response;

import lombok.Builder;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Builder
public record MovieResponse(Long id, String title, String description, LocalDate releaseDate, Double rating, LocalDateTime createdAt, LocalDateTime updateAt) {
}
