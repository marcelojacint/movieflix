package com.marcelodev.movieflix.config;

import com.marcelodev.movieflix.exception.CategoryException;
import com.marcelodev.movieflix.exception.MovieException;
import com.marcelodev.movieflix.exception.StreamingException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ApplicationControllerAdvice {

    @ExceptionHandler(MovieException.class)
    public ResponseEntity<Object> handleMovieNotFound(MovieException ex) {
        return getObjectResponseEntity(ex.getMessage(), ex);
    }

    @ExceptionHandler(CategoryException.class)
    public ResponseEntity<Object> handleCategoryNotFound(CategoryException ex) {
        return getObjectResponseEntity(ex.getMessage(), ex);
    }

    @ExceptionHandler(StreamingException.class)
    public ResponseEntity<Object> handlerStreamingNotFound(StreamingException ex) {
        return getObjectResponseEntity(ex.getMessage(), ex);
    }

    private ResponseEntity<Object> getObjectResponseEntity(String message, Exception ex) {
        Map<String, Object> body = new HashMap<>();
        body.put("status", HttpStatus.NOT_FOUND.value());
        body.put("error", "not found");
        body.put("message", message);
        body.put("timestamp", LocalDateTime.now());

        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }
}
