package com.marcelodev.movieflix.controller;

import com.fasterxml.jackson.databind.cfg.MapperBuilder;
import com.marcelodev.movieflix.controller.request.CategoryRequest;
import com.marcelodev.movieflix.controller.response.CategoryResponse;
import com.marcelodev.movieflix.entity.Category;
import com.marcelodev.movieflix.mapper.CategoryMapper;
import com.marcelodev.movieflix.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponse> findById(@PathVariable Long id) {
             return categoryService.findById(id)
                     .map(category -> ResponseEntity.ok(CategoryMapper.toCategoryResponse(category)))
                     .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<CategoryResponse> save(@RequestBody CategoryRequest categoryRequest) {
       CategoryResponse categoryResponse = CategoryMapper.toCategoryResponse( categoryService.create(CategoryMapper.toCategory(categoryRequest)));
        return ResponseEntity.status(HttpStatus.CREATED).body(categoryResponse);
    }
}
