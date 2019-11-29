package com.codegym.freshfood.service;

import com.codegym.freshfood.model.Category;

public interface CategoryService {
    Iterable<Category> findAllCategory();
}
