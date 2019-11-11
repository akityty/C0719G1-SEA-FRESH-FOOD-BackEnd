package com.codegym.freshfood.service;

import com.codegym.freshfood.model.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    void save(User user);
}
