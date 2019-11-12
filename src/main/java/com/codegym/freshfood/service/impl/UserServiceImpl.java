package com.codegym.freshfood.service.impl;

import com.codegym.freshfood.model.User;
import com.codegym.freshfood.repository.UserRepository;
import com.codegym.freshfood.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public void save(User user) {
    userRepository.save(user);
    }
    @Override
    public List<User> findAll() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public Long checkLogin(String email, String password) {
        List<User> users = findAll();
        for (User user : users) {
            if (user.getEmail().equals(email)) {
                if (user.getPassword().equals(password))
                    return user.getId(); //ok
                return 0L; //email dung pass sai
            }
        }
        return -1L; //email sai
    }

}
