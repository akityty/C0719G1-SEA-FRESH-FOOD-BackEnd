package com.codegym.freshfood.service.impl;

import com.codegym.freshfood.model.Picture;
import com.codegym.freshfood.model.Product;
import com.codegym.freshfood.repository.PictureRepository;
import com.codegym.freshfood.repository.ProductRepository;
import com.codegym.freshfood.service.PictureService;
import com.codegym.freshfood.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class ProductServiceImpl implements ProductService {
  @Autowired
  ProductRepository productRepository;
  @Autowired
  PictureRepository pictureRepository;

  @Override
  public void save(Product product) {
    productRepository.save(product);
  }

  @Override
  public List<Product> findAll() {
    return productRepository.findAll();
  }

  @Override
  public Iterable<Product> findAllProduct() {
    return productRepository.findAll();
  }

  @Override
  public Optional<Product> findById(Long id) {
    return productRepository.findById(id);
  }

  @Override
  public void delete(Long id) {
    Optional<Product> product = productRepository.findById(id);
    List<Picture> pictureList = pictureRepository.findAllByProductId(product.get().getId());
    for (Picture picture: pictureList) {
      pictureRepository.delete(picture);
    }
    productRepository.delete(product.get());
  }

  @Override
  public List<Product> getAllByCategoryId(Long id) {
    return productRepository.getAllByCategoryId(id);
  }

  @Override
  public List<Product> findAllByName(String name) {
    return productRepository.findAllByName(name);
  }

  @Override
  public List<Product> findAllByOrigin(String origin) {
    return productRepository.findAllByOrigin(origin);
  }

  @Override
  public List<Product> findAllByPriceBetween(Double price, Double price2) {
    return productRepository.findAllByPriceBetween(price, price2);
  }
}
