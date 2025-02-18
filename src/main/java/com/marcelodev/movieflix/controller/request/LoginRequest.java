package com.marcelodev.movieflix.controller.request;

import lombok.Builder;

@Builder
public record LoginRequest(String email, String password) {
}
