package com.marcelodev.movieflix.controller.response;

import lombok.Builder;

@Builder
public record CategoryResponse(Long id, String name, String description) {
}
