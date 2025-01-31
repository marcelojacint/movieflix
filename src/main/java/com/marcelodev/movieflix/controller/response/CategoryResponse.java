package com.marcelodev.movieflix.controller.response;

import lombok.Builder;

@Builder
public record CategoryResponse(String id, String name, String description) {
}
