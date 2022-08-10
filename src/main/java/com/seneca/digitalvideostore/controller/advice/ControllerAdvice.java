package com.seneca.digitalvideostore.controller.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, String> handle(MethodArgumentNotValidException exception) {
        Map<String, String> fieldErrorMap = new HashMap<>();
        exception.getBindingResult()
                .getFieldErrors()
                .forEach(fieldError -> fieldErrorMap.put(fieldError.getField(), fieldError.getDefaultMessage()));

        return fieldErrorMap;
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, String> handle(ConstraintViolationException exception) {
        Map<String, String> constraintViolationMap = new HashMap<>();
        exception.getConstraintViolations()
                .forEach(constraintViolation -> constraintViolationMap.put(constraintViolation.getPropertyPath().toString(), constraintViolation.getMessage()));

        return constraintViolationMap;
    }
}
