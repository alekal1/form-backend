package com.example.formbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Configuration;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

import static com.example.formbackend.constance.C.PERSON_SEQUENCE;
import static com.example.formbackend.constance.C.DEFAULT_ALLOCATIONSIZE;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
@Configuration
public class PersonDto {
    @Id
    @SequenceGenerator(
            name = PERSON_SEQUENCE,
            sequenceName = PERSON_SEQUENCE,
            allocationSize = DEFAULT_ALLOCATIONSIZE
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = PERSON_SEQUENCE
    )
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String text;

    @OneToMany
    private List<CategoryDto> categories;

    @Transient
    private String postedDate;


    public LocalDate getPostedDate() {
        return LocalDate.now();
    }

    public PersonDto(String firstName,
                     String lastName,
                     String email,
                     String text,
                     List<CategoryDto> categories) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.text = text;
        this.categories = categories;
    }
}
