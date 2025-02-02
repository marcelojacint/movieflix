package com.marcelodev.movieflix.service;

import com.marcelodev.movieflix.entity.Category;
import com.marcelodev.movieflix.exception.CategoryException;
import com.marcelodev.movieflix.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

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

    public Optional<Category> findById(Long id) {
        if  (!categoryRepository.existsById(id)) {
            throw new CategoryException("there are no categories");
        }
        return categoryRepository.findById(id);

    }

    public Category create(Category category) {
        return categoryRepository.save(category);
            }
}
