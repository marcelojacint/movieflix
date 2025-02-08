package com.marcelodev.movieflix.controller.request;

import lombok.Builder;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Builder
public record MovieRequest(String title, String description, LocalDate releaseDate, Double rating, LocalDateTime createdAt, LocalDateTime updateAt) {
}
