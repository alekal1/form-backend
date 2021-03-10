package com.example.formbackend.service;

import com.example.formbackend.dao.CategoryRepository;
import com.example.formbackend.dto.CategoryDto;
import com.example.formbackend.exceptions.CategoryAlreadyExists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<CategoryDto> getAllCategories() {
        return categoryRepository.findAll();
    }

    public void addNewCategory(CategoryDto categoryDto) {
        if (!ifCategoryExist(categoryDto)) {
            categoryRepository.save(categoryDto);
        }
    }

    private Boolean ifCategoryExist(CategoryDto categoryDto) {
        Optional<CategoryDto> categoryDtoByCategoryNameOptional =
                categoryRepository.findCategoryDtoByCategoryName(categoryDto.getCategoryName());
        if (categoryDtoByCategoryNameOptional.isPresent()) {
            throw new CategoryAlreadyExists("Category already exists");
        }
        return false;
    }
}
