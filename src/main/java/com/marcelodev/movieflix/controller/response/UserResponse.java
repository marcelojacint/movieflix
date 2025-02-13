package com.marcelodev.movieflix.controller.response;

import lombok.Builder;

@Builder
public record UserResponse(Long id,
                           String username,
                           String email
) {
}
