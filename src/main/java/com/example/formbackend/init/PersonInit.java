package com.example.formbackend.init;

import com.example.formbackend.dao.CategoryRepository;
import com.example.formbackend.dao.PersonRepository;
import com.example.formbackend.dto.PersonDto;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class PersonInit {

    @Bean
    CommandLineRunner personCommandLineRunner(
            PersonRepository personRepository,
            CategoryRepository categoryRepository
            ) {
        return args -> {
            PersonDto foo = new PersonDto(
                    "testFirstName",
                    "testLastName",
                    "testEmail",
                    "testText",
                    List.of(
                            categoryRepository.findCategoryById(1L),
                            categoryRepository.findCategoryById(2L)
                    )
            );

            PersonDto bar = new PersonDto(
                    "testFirstName",
                    "testLastName",
                    "testEmail",
                    "testText",
                    List.of(
                            categoryRepository.findCategoryById(3L)

                    )
            );
            personRepository.saveAll(
                    List.of(foo, bar)
            );
        };
    }
}
