package com.marcelodev.movieflix.controller.request;

import lombok.Builder;

@Builder
public record UserRequest(String username,
                          String email,
                          String password) {
}
