package com.example.formbackend.controller;

import com.example.formbackend.dto.CategoryDto;
import com.example.formbackend.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping(path = "api/v1/category")
public class CategoryController {

    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/all")
    public List<CategoryDto> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @PostMapping("/add")
    public void addNewCategory(@RequestBody CategoryDto categoryDto) {
        categoryService.addNewCategory(categoryDto);
    }
}
