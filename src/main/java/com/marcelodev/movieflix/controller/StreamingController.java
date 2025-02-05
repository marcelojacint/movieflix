package com.marcelodev.movieflix.controller;

import com.marcelodev.movieflix.controller.response.StreamingResponse;
import com.marcelodev.movieflix.entity.Streaming;
import com.marcelodev.movieflix.mapper.StreamingMapper;
import com.marcelodev.movieflix.service.StreamingService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
}
