package com.exam.controller;

import com.exam.entity.User;
import com.exam.service.UserService;
import com.exam.utils.Constants;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value="/api/v1/users")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/register")
    public ResponseEntity<Map<String,String>> registerUser(@RequestBody Map<String,Object> userMap) {
        String firstName = String.valueOf(userMap.get("firstName"));
        String lastName = String.valueOf(userMap.get("lastName"));
        String email = String.valueOf(userMap.get("email"));
        String password = String.valueOf(userMap.get("password"));
        User user = userService.registerUser(firstName,lastName,email,password);
        Map<String,String> responseMap = new HashMap<>();
        responseMap.put("message","User " + user.getEmail() + " registered successfully with ID: " + user.getUserId());
        return new ResponseEntity<>(responseMap, HttpStatus.OK);
    }

    @PostMapping("/login")
    public  ResponseEntity<Map<String,String>> loginUser(@RequestBody Map<String, Object> userMap) {
        String email = String.valueOf(userMap.get("email"));
        String password = String.valueOf(userMap.get("password"));
        User user = userService.validateUser(email,password);
        Map<String, String> responseMap = generateJWTToken(user);
        responseMap.put("massage","User loggedIn successfully");
        return  new ResponseEntity<>(responseMap,HttpStatus.OK);
    }

    private Map<String,String> generateJWTToken(User user) {
        long timestamp = System.currentTimeMillis();
        String token = Jwts.builder().signWith(SignatureAlgorithm.HS256, Constants.API_SECRET_KEY)
                .setIssuedAt(new Date(timestamp))
                .setExpiration(new Date(timestamp + Constants.TOKEN_VALID_TIME))
                .claim("userId", user.getUserId())
                .claim("email", user.getEmail())
                .claim("firstName", user.getFirstName())
                .claim("lastName", user.getLastName())
                .compact();
        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token",token);
        return tokenMap;
    }
}
