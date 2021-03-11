package com.example.formbackend.init;

import com.example.formbackend.dao.PersonRepository;
import com.example.formbackend.dto.PersonDto;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

/***
 * Initializer class just to fill database with some values
 */
@Configuration
public class PersonInit {

    @Bean
    CommandLineRunner personCommandLineRunner(
            PersonRepository personRepository
            ) {
        return args -> {
            PersonDto foo = new PersonDto(
                    "Alex",
                    "Bob",
                    "bob@foo.com",
                    "Comment text from Alex",
                    "Jewelerry, Pets",
                    LocalDate.now().toString()
            );

            PersonDto bar = new PersonDto(
                    "Alice",
                    "Smith",
                    "Alice@bar.com",
                    "Comment text from Alex",
                    "Food & Drinks",
                    LocalDate.now().toString()
            );
            personRepository.saveAll(
                    List.of(foo, bar)
            );
        };
    }
}
