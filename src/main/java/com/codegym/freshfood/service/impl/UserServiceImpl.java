package com.codegym.freshfood.service.impl;

import com.codegym.freshfood.model.User;
import com.codegym.freshfood.repository.UserRepository;
import com.codegym.freshfood.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public void save(User user) {
    userRepository.save(user);
    }

}
