package com.codegym.freshfood.service;

import com.codegym.freshfood.model.signinSignup.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
  Optional<User> findById(Long id);
  Optional<User> findByEmail(String email);
  Optional<User> findByUsername(String username);
  void save(User user);
  List<User> findAll();
}
