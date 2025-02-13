package com.marcelodev.movieflix.service;

import com.marcelodev.movieflix.entity.User;
import com.marcelodev.movieflix.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {

    private UserRepository userRepository;

    public User save(User user) {
        return userRepository.save(user);
    }
}
