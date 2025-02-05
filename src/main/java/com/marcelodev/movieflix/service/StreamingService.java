package com.marcelodev.movieflix.service;

import com.marcelodev.movieflix.entity.Streaming;
import com.marcelodev.movieflix.exception.StreamingException;
import com.marcelodev.movieflix.repository.StreamingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class StreamingService {

    private StreamingRepository streamingRepository;

    public List<Streaming> findAll() {
         if(streamingRepository.findAll().isEmpty()) {
             throw new StreamingException("No streaming found");
         }
         return streamingRepository.findAll();
    }

}
