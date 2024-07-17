package com.exam.exceptions;

public class CalculatorAuthException extends RuntimeException{
    public CalculatorAuthException(String message) {
        super(message);
    }
}
