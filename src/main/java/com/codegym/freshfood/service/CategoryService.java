package com.codegym.freshfood.service;

import com.codegym.freshfood.model.Category;

import java.util.Optional;

public interface CategoryService {
  void save(Category category);
  void delete(Long id);
  Optional<Category> findById(Long id);
}
