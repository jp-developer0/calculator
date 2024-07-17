package com.exam.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CalculatorExceptionHandler {

    @ExceptionHandler(CalculatorAuthException.class)
    public ResponseEntity<ErrorResponse> handleAuthValidationException(CalculatorAuthException exception) {
        return new ResponseEntity<>(new ErrorResponse().setErrorMessage(exception.getMessage()), HttpStatus.UNAUTHORIZED);
    }
}
