package com.codegym.freshfood.service;

import com.codegym.freshfood.model.Product;
import com.codegym.freshfood.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class ProductServiceImpl implements ProductService{
  @Autowired
  ProductRepository productRepository;
  @Override
  public void save(Product product) {
    productRepository.save(product);
  }
}
