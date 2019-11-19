package com.codegym.freshfood.service;

import com.codegym.freshfood.model.signinSignup.User;
import com.codegym.freshfood.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class UserServiceImpl implements UserService {
  @Autowired
  UserRepository userRepository;
  @Override
  public Optional<User> findById(Long id) {
    return userRepository.findById(id);
  }

  @Override
  public Optional<User> findByEmail(String email) {
    return userRepository.findByEmail(email);
  }

  @Override
  public Optional<User> findByUsername(String username) {
    return userRepository.findByUsername(username);
  }
}
