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
                    "Alex",
                    "Bob",
                    "bob@bar.com",
                    "Comment text from Alex",
                    List.of(
                            categoryRepository.findCategoryById(1L),
                            categoryRepository.findCategoryById(2L)
                    )
            );

            PersonDto bar = new PersonDto(
                    "Alice",
                    "Smith",
                    "alice@foo.com",
                    "Comment text from Alice",
                    List.of(
                            categoryRepository.findCategoryById(1L),
                            categoryRepository.findCategoryById(2L),
                            categoryRepository.findCategoryById(3L)

                    )
            );

            PersonDto faz = new PersonDto(
                    "Juan",
                    "Shmidt",
                    "juan@faz.com",
                    "Comment text from Juan",
                    List.of(
                            categoryRepository.findCategoryById(1L),
                            categoryRepository.findCategoryById(2L),
                            categoryRepository.findCategoryById(3L)

                    )
            );
            personRepository.saveAll(
                    List.of(foo, bar)
            );
        };
    }
}
