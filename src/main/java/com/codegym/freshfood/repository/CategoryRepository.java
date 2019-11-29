package com.codegym.freshfood.repository;

import com.codegym.freshfood.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
