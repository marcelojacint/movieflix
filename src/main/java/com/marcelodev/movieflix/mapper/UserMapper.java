package com.marcelodev.movieflix.mapper;

import com.marcelodev.movieflix.controller.request.UserRequest;
import com.marcelodev.movieflix.controller.response.UserResponse;
import com.marcelodev.movieflix.entity.User;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UserMapper {

    public static User toUser(UserRequest userRequest) {
        return User
                .builder()
                .username(userRequest.username())
                .email(userRequest.email())
                .password(userRequest.password())
                .build();
    }

    public static UserResponse toUserResponse(User user) {
        return UserResponse
                .builder()
                .id(user.getId())
                .username(user.getUsername())
                .email(user.getEmail())
                .build();
    }
}
