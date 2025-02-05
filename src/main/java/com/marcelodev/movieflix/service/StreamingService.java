package com.marcelodev.movieflix.service;

import com.marcelodev.movieflix.entity.Streaming;
import com.marcelodev.movieflix.exception.StreamingException;
import com.marcelodev.movieflix.repository.StreamingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Optional<Streaming> findById(Long id) {
        if (!streamingRepository.existsById(id)) {
            throw new StreamingException("No streaming found");
        }
        return streamingRepository.findById(id);
    }

    public Streaming save(Streaming streaming) {
        if (!streamingRepository.existsById(streaming.getId())) {
            throw new StreamingException("No streaming found");
        }
        return streamingRepository.save(streaming);
    }

}
