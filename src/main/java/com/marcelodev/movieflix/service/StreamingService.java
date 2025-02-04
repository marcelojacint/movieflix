package com.marcelodev.movieflix.service;

import com.marcelodev.movieflix.repository.StreamingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class StreamingService {

    private StreamingRepository streamingRepository;
}
