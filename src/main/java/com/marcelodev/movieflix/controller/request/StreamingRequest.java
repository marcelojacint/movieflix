package com.marcelodev.movieflix.controller.request;

import lombok.Builder;

@Builder
public record StreamingRequest(String name) {
}
