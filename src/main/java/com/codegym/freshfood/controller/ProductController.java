package com.codegym.freshfood.controller;

import com.codegym.freshfood.model.Picture;
import com.codegym.freshfood.model.Product;
import com.codegym.freshfood.service.PictureService;
import com.codegym.freshfood.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/product")
public class ProductController {
  @Autowired
  ProductService productService;
  @Autowired
  PictureService pictureService;

  @GetMapping("/list")
  public ResponseEntity<List<Product>> getAllProduct() {
    List<Product> productList = productService.findAll();
    if (productList != null) {
      return new ResponseEntity<List<Product>>(productList, HttpStatus.OK);
    } else {
      return new ResponseEntity<List<Product>>(HttpStatus.NOT_FOUND);
    }
  }
  @GetMapping("/{id}")
  public ResponseEntity<Product> getProduct(@PathVariable Long id){
    Optional<Product> product = productService.findById(id);
    if(product.isPresent()){
      return new ResponseEntity<Product>(product.get(), HttpStatus.OK);
    }else{
      return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
    }
  }

  @PostMapping("/add")
  public ResponseEntity createProduct(@RequestBody Product product) {
/*    try {
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
    }*/
    productService.save(product);
    return new ResponseEntity(HttpStatus.CREATED);
  }
  @PutMapping("/update/{id}")
  public ResponseEntity productResponseEntity(@PathVariable Long id, @RequestBody Product product){
    Optional<Product> currentProduct = productService.findById(id);
    if(currentProduct.isPresent()){
      currentProduct.get().setName(product.getName());
      currentProduct.get().setCategory(product.getCategory());
      currentProduct.get().setAmount(product.getAmount());
      currentProduct.get().setPicture(product.getPicture());
      currentProduct.get().setDescription(product.getDescription());
      currentProduct.get().setPrice(product.getPrice());
      currentProduct.get().setOrigin(product.getOrigin());
      currentProduct.get().setProvider(product.getProvider());
      currentProduct.get().setStatus(product.getStatus());
      productService.save(currentProduct.get());
      return new ResponseEntity (HttpStatus.OK);
    }else{
      return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
  }
  @DeleteMapping("/delete/{id}")
  public ResponseEntity deleteProduct(@PathVariable Long id){
    Optional<Product> product = productService.findById(id);
    if(product.isPresent()){
      productService.delete(product.get().getId());
      return new ResponseEntity(HttpStatus.OK);
    }else{
      return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
  }
  @GetMapping("/getAllByCategoryId/{id}")
  public ResponseEntity<List<Product>> getAllByCategoryId(@PathVariable Long id){
    List<Product> productList = productService.getAllByCategoryId(id);
    if (productList != null) {
      return new ResponseEntity<List<Product>>(productList, HttpStatus.OK);
    } else {
      return new ResponseEntity<List<Product>>(HttpStatus.NOT_FOUND);
    }
  }
  @GetMapping("/findAllByName")
  public ResponseEntity<List<Product>> findAllByName(@RequestParam String name){
    List<Product> productList = productService.findAllByName(name);
    if (productList != null) {
      return new ResponseEntity<List<Product>>(productList, HttpStatus.OK);
    } else {
      return new ResponseEntity<List<Product>>(HttpStatus.NOT_FOUND);
    }
  }
  @GetMapping("/findAllByOrigin/{origin}")
  public ResponseEntity<List<Product>> findAllByOrigin(@PathVariable String origin){
    List<Product> productList = productService.findAllByOrigin(origin);
    if (productList != null) {
      return new ResponseEntity<List<Product>>(productList, HttpStatus.OK);
    } else {
      return new ResponseEntity<List<Product>>(HttpStatus.NOT_FOUND);
    }
  }
  @GetMapping("/findAllByPriceBetween/{price}&&{price2}")
  public ResponseEntity<List<Product>> findAllByPriceBetween(@PathVariable Double price, @PathVariable Double price2){
    List<Product> productList = productService.findAllByPriceBetween(price,price2);
    if (productList != null) {
      return new ResponseEntity<List<Product>>(productList, HttpStatus.OK);
    } else {
      return new ResponseEntity<List<Product>>(HttpStatus.NOT_FOUND);
    }
  }
}
