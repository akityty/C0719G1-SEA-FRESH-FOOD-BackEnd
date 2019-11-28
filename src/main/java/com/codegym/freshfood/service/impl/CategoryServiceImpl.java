package com.codegym.freshfood.service.impl;

import com.codegym.freshfood.model.Category;
import com.codegym.freshfood.model.Picture;
import com.codegym.freshfood.model.Product;
import com.codegym.freshfood.repository.CategoryRepository;
import com.codegym.freshfood.repository.PictureRepository;
import com.codegym.freshfood.repository.ProductRepository;
import com.codegym.freshfood.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class CategoryServiceImpl implements CategoryService {
  @Autowired
  ProductRepository productRepository;
  @Autowired
  PictureRepository pictureRepository;
  @Autowired
  CategoryRepository categoryRepository;
  @Override
  public void save(Category category) {
    categoryRepository.save(category);
  }

  @Override
  public void delete(Long id) {
    Optional<Category> category = categoryRepository.findById(id);
    List<Product> productList = productRepository.getAllByCategoryId(category.get().getId());
    for (Product product: productList) {
      List<Picture> pictureList = pictureRepository.findAllByProductId(product.getId());
      for (Picture picture: pictureList) {
        pictureRepository.delete(picture);
      }
      productRepository.delete(product);
    }
    categoryRepository.delete(category.get());
  }

  @Override
  public Optional<Category> findById(Long id) {
    return categoryRepository.findById(id);
  }

}
