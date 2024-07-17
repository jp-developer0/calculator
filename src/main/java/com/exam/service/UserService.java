package com.exam.service;

import com.exam.entity.User;
import com.exam.exceptions.CalculatorAuthException;

public interface UserService {
    User validateUser(String email, String password) throws CalculatorAuthException;
    User registerUser(String firstName, String lastName, String email, String password) throws CalculatorAuthException;
}
