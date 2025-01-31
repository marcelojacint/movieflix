package com.marcelodev.movieflix.controller;

import com.marcelodev.movieflix.controller.response.CategoryResponse;
import com.marcelodev.movieflix.entity.Category;
import com.marcelodev.movieflix.mapper.CategoryMapper;
import com.marcelodev.movieflix.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/movieflix/category")
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<CategoryResponse>> findAll() {
        List<CategoryResponse> categoryResponses = categoryService.findAll()
                .stream().map(CategoryMapper::toCategoryResponse).toList();
        return ResponseEntity.ok(categoryResponses);
    }
}
