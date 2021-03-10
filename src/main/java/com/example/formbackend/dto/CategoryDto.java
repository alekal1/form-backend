package com.example.formbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;

import static com.example.formbackend.constance.C.CATEGORY_SEQUENCE;
import static com.example.formbackend.constance.C.DEFAULT_ALLOCATIONSIZE;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
@Transactional
public class CategoryDto {
    @Id
    @SequenceGenerator(
            name = CATEGORY_SEQUENCE,
            sequenceName = CATEGORY_SEQUENCE,
            allocationSize = DEFAULT_ALLOCATIONSIZE
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = CATEGORY_SEQUENCE
    )
    private Long id;
    private String categoryName;

    public CategoryDto(String categoryName) {
        this.categoryName = categoryName;
    }
}
