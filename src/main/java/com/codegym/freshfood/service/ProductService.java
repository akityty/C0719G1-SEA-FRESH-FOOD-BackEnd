package com.codegym.freshfood.service;

import com.codegym.freshfood.model.Product;

public interface ProductService {
    Iterable<Product> findAllProduct();

    void save(Product product);
//    Product findById()
}
