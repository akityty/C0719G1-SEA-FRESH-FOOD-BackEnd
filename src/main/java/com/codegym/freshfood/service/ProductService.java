package com.codegym.freshfood.service;

import com.codegym.freshfood.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    void save(Product product);
    List<Product> findAll();

  Iterable<Product> findAllProduct();
  Optional<Product> findById(Long id);
  void delete(Long id);
  List<Product> getAllByCategoryId(Long id);
  List<Product> findAllByName(String name);
  List<Product> findAllByOrigin(String origin);
  List<Product> findAllByPriceBetween(Double price, Double price2);
}
