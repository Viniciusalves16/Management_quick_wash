package com.example.management.exception;


import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.awt.*;

@RestControllerAdvice
public class ExceptionGeral {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity notFoundError404(EntityNotFoundException e) {
        return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity badRequest400(MethodArgumentNotValidException exception) {
        var errors = exception.getFieldErrors();
        return ResponseEntity.badRequest().body(errors.stream().map(errorValidation::new).toList());
    }

    private record errorValidation(String atribute, String message) {
        public errorValidation(FieldError error) {
            this(error.getField(), error.getDefaultMessage());
        }
    }
}
