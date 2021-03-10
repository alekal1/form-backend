package com.example.formbackend.init;

import com.example.formbackend.dao.CategoryRepository;
import com.example.formbackend.dto.CategoryDto;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class CategoryInit {

    @Bean
    CommandLineRunner categoryCommandLineRunner(CategoryRepository categoryRepository) {
        return args -> {
            CategoryDto cat1 = new CategoryDto("TestCategory");
            CategoryDto cat2 = new CategoryDto("TestCategory2");
            CategoryDto cat3 = new CategoryDto("TestCategory3");
            categoryRepository.saveAll(
                    List.of(cat1, cat2, cat3)
            );
        };
    }
}
