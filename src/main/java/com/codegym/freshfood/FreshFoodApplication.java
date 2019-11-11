package com.codegym.freshfood;

import com.codegym.freshfood.service.UserService;
import com.codegym.freshfood.service.impl.UserServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FreshFoodApplication {

    public static void main(String[] args) {
        SpringApplication.run(FreshFoodApplication.class, args);

        }
    @Bean
    public UserService userService() {
        return new UserServiceImpl() {
        };
    }

}
