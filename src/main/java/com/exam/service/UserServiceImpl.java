package com.exam.service;

import com.exam.entity.User;
import com.exam.exceptions.CalculatorAuthException;
import com.exam.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Locale;
import java.util.regex.Pattern;

@Service
@Transactional
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;

    @Override
    public User validateUser(String email, String password) throws CalculatorAuthException {
        if (email != null) {
            email = email.toLowerCase();
        }
        return userRepository.findByEmailAndPassword(email,password);
    }

    @Override
    public User registerUser(String firstName, String lastName, String email, String password) throws CalculatorAuthException {
        Pattern pattern = Pattern.compile("^(.+)@(.+)$");
        if (email != null) {
            email = email.toLowerCase();
        }
        if (!pattern.matcher(email).matches()) {
            throw new CalculatorAuthException("Invalid email format");
        }
        Integer count = userRepository.getCountByEmail(email);
        if (count > 0) {
            throw new CalculatorAuthException("Email is already used. Please select another one");
        }
        Integer userId = userRepository.create(firstName,lastName,email,password);

        return userRepository.findById(userId);
    }
}
