package com.example.formbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Configuration;

import javax.persistence.*;

import static com.example.formbackend.constance.C.PERSON_SEQUENCE;
import static com.example.formbackend.constance.C.DEFAULT_ALLOCATIONSIZE;

/***
 * Data transfer object represent prototype of object in table of database
 */
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
    private String postedDate;
    private String categories;


    public PersonDto(String firstName,
                     String lastName,
                     String email,
                     String text,
                     String categories,
                     String postedDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.text = text;
        this.categories = categories;
        this.postedDate = postedDate;
    }
}
