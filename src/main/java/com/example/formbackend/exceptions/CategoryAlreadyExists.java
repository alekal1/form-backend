package com.example.formbackend.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class CategoryAlreadyExists extends RuntimeException {

    public CategoryAlreadyExists(String message) {
        super(message);
    }
}
