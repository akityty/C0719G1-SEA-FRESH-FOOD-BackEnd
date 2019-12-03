package com.codegym.freshfood;

import com.codegym.freshfood.security.services.UserDetailsServiceImpl;
import com.codegym.freshfood.service.*;
import com.codegym.freshfood.service.impl.*;
import org.springframework.beans.BeansException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class FreshFoodApplication {

    public static void main(String[] args) {
        SpringApplication.run(FreshFoodApplication.class, args);

        }
    @Bean
    public UserDetailsService userDetailsService(){
        return new UserDetailsServiceImpl();
    }
    @Bean
    public UserService userService() {
        return new UserServiceImpl();
    }
    @Bean
    public ProductService productService(){
        return new ProductServiceImpl();
    }
    @Bean
    public PictureService pictureService(){
        return new PictureServiceImpl();
    }
    @Bean
    public CategoryService categoryService(){
        return new CategoryServiceImpl();
    }
    @Bean
    public ProviderService providerService(){
        return new ProviderServiceImpl();
    }
    @Bean
    public OrderService orderService(){
        return new OrderServiceImpl();
    }
    @Configuration
    static
    class WebConfig implements WebMvcConfigurer, ApplicationContextAware {

        private ApplicationContext appContext;

        @Override
        public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
            appContext = applicationContext;
        }


    }
}
