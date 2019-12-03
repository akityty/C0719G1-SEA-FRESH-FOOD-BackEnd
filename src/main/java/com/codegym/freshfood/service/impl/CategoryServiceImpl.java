package com.codegym.freshfood.service.impl;

import com.codegym.freshfood.model.Category;
import com.codegym.freshfood.repository.CategoryRepository;
import com.codegym.freshfood.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public void save(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public void delete(Long id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public Optional<Category> findById(Long id) {
        return categoryRepository.findById(id);
    }

    @Override
    public Iterable<Category> findAllCategory() {
        return categoryRepository.findAll();
    }
}
