package com.marcelodev.movieflix.service;

import com.marcelodev.movieflix.entity.Category;
import com.marcelodev.movieflix.exception.CategoryException;
import com.marcelodev.movieflix.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public List<Category> findAll() {
        List<Category> categories = categoryRepository.findAll();
        if (categories.isEmpty()) {
            throw new CategoryException("there are no categories");
        }
        return categories;
    }
}
