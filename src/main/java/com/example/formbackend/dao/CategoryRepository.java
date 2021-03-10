package com.example.formbackend.dao;

import com.example.formbackend.dto.CategoryDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface CategoryRepository extends JpaRepository<CategoryDto, Long> {

    CategoryDto findCategoryById(Long id);

    Optional<CategoryDto> findCategoryDtoByCategoryName(String name);

}
