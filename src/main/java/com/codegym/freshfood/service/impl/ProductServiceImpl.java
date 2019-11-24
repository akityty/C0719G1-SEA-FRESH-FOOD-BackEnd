package com.codegym.freshfood.service.impl;

import com.codegym.freshfood.model.Product;
import com.codegym.freshfood.repository.ProductRepository;
import com.codegym.freshfood.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;

public class ProductServiceImpl implements ProductService {
  @Autowired
  ProductRepository productRepository;

  @Override
  public Iterable<Product> findAllProduct() {
    return productRepository.findAll();
  }

  @Override
  public void save(Product product) {
    productRepository.save(product);
  }
}
