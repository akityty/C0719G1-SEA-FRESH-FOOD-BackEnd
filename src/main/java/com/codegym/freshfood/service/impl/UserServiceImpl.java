package com.codegym.freshfood.service.impl;

import com.codegym.freshfood.model.signinSignup.User;
import com.codegym.freshfood.repository.UserRepository;
import com.codegym.freshfood.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
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

  @Override
  public void save(User user) {
    userRepository.save(user);
  }

  @Override
  public List<User> findAll() {
    return userRepository.findAll();
  }

  @Override
  public void delete(User user) {
    userRepository.delete(user);
  }
}
