package com.marcelodev.movieflix.controller.request;

import lombok.Builder;

@Builder
public record CategoryRequest(String name, String description) {
}
