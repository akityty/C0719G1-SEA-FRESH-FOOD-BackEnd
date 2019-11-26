package com.codegym.freshfood.controller;

import com.codegym.freshfood.model.Picture;
import com.codegym.freshfood.model.Product;
import com.codegym.freshfood.service.PictureService;
import com.codegym.freshfood.service.ProductService;
import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/product")
public class ProductController {
  @Autowired
 private ProductService productService;
  @Autowired
  private PictureService pictureService;

  @GetMapping("/home")
  public ResponseEntity showListProduct(){
    try {
      Iterable<Product> products = productService.findAllProduct();
      for (Product product: products){
          System.out.println(product.getPicture().size());
      }
        return new ResponseEntity<Iterable<Product>>(products,HttpStatus.OK);
    }catch (ExpiredJwtException e ){
      return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
  }


  @PostMapping("/add")
//  @PreAuthorize("hasRole('ADMIN')")
  public ResponseEntity addNewProduct(@RequestBody Product product){
    try {
      productService.save(product);
      Iterable<Product> products = productService.findAllProduct();
      Product product1 = new Product();
      for (Product product2: products){
          product1 = product2;
      }
      for (Picture picture : product.getPicture()){
          picture.setProduct(product1);
          pictureService.save(picture);
      }
      return new ResponseEntity(HttpStatus.CREATED);
    }catch (Exception e){
      return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }
  }
}
