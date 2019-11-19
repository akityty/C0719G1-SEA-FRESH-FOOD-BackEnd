package com.codegym.freshfood.controller;

import com.codegym.freshfood.model.Product;
import com.codegym.freshfood.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/product")
public class ProductController {
  @Autowired
  ProductService productService;
  @PostMapping("/add")
  @PreAuthorize("hasRole('ADMIN')")
  public ResponseEntity addNewProduct(@Valid @RequestBody Product product, UriComponentsBuilder ucBuilder){
    System.out.println("Creating Product " + product.getName());
    productService.save(product);
    HttpHeaders headers = new HttpHeaders();
    headers.setLocation(ucBuilder.path("/products/{id}").buildAndExpand(product.getId()).toUri());
    return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
  }
}
