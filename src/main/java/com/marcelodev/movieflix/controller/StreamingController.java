package com.marcelodev.movieflix.controller;

import com.marcelodev.movieflix.controller.request.StreamingRequest;
import com.marcelodev.movieflix.controller.response.StreamingResponse;
import com.marcelodev.movieflix.entity.Streaming;
import com.marcelodev.movieflix.mapper.StreamingMapper;
import com.marcelodev.movieflix.service.StreamingService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
@RequestMapping("/movieflix/streaming")
public class StreamingController {

    private final StreamingService streamingService;

    @GetMapping
    public ResponseEntity<List<StreamingResponse>> findAll() {
        List<StreamingResponse> streamingResponses = streamingService.findAll()
                .stream()
                .map(StreamingMapper::toStreamingResponse).toList();
        return ResponseEntity.ok(streamingResponses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StreamingResponse> findById(@PathVariable Long id) {
        return streamingService.findById(id)
                .map(streaming -> ResponseEntity.ok(StreamingMapper.toStreamingResponse(streaming)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<StreamingResponse> save(@RequestBody StreamingRequest streamingRequest) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(StreamingMapper.toStreamingResponse(streamingService
                        .save(StreamingMapper.toStreaming(streamingRequest
                        ))));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        streamingService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
