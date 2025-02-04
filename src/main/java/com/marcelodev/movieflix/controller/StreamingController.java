package com.marcelodev.movieflix.controller;

import com.marcelodev.movieflix.service.StreamingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/movieflix/streaming")
public class StreamingController {

    private final StreamingService streamingService;
}
