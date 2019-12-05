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
    public Iterable<Category> findAllCategory() {
        return categoryRepository.findAll();
    }

    @Override
    public void save(Category category) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Optional<Category> findById(Long id) {
        return Optional.empty();
    }
}
