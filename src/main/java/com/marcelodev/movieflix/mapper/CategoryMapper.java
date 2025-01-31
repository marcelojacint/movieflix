package com.marcelodev.movieflix.mapper;

import com.marcelodev.movieflix.controller.request.CategoryRequest;
import com.marcelodev.movieflix.controller.response.CategoryResponse;
import com.marcelodev.movieflix.entity.Category;
import lombok.experimental.UtilityClass;

@UtilityClass
public class CategoryMapper {

    public static Category toCategory(CategoryRequest categoryRequest) {
        return Category
                .builder()
                .name(categoryRequest.name())
                .description(categoryRequest.description())
                .build();
    }

    public static CategoryResponse toCategoryResponse(Category category) {
        return CategoryResponse
                .builder()
                .id(category.getId())
                .name(category.getName())
                .description(category.getDescription())
                .build();
    }

}
