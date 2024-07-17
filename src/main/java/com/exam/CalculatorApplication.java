package com.exam;

import com.exam.validation.AuthValidation;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CalculatorApplication {
    public static void main(String[] args) {
        SpringApplication.run(CalculatorApplication.class);
    }

    @Bean
    public FilterRegistrationBean<AuthValidation> filterRegistrationBean() {
        FilterRegistrationBean<AuthValidation> registrationBean = new FilterRegistrationBean<>();
        AuthValidation authValidation = new AuthValidation();
        registrationBean.setFilter(authValidation);
        registrationBean.addUrlPatterns("/api/v1/calculator/*");
        return registrationBean;
    }
}
