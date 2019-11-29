package com.codegym.freshfood.repository;

import com.codegym.freshfood.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
  List<Product> getAllByCategoryId(Long category_id);
  List<Product> findAllByName(String name);
  List<Product> findAllByOrigin(String origin);
  List<Product> findAllByPriceBetween(Double price, Double price2);
}
