package com.codegym.freshfood.controller;
import com.codegym.freshfood.model.Picture;
import com.codegym.freshfood.model.Product;
import com.codegym.freshfood.service.PictureService;
import com.codegym.freshfood.service.ProductService;
import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private PictureService pictureService;

    @GetMapping("/home")
    public ResponseEntity showListProduct() {
        try {
            Iterable<Product> products = productService.findAllProduct();
            return new ResponseEntity<Iterable<Product>>(products, HttpStatus.OK);
        } catch (ExpiredJwtException e) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/add")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity addNewProduct(@RequestBody Product product) {
        try {
            productService.save(product);
            for (Picture picture : product.getPicture()) {
                picture.setProduct(product);
                pictureService.save(picture);
            }
            return new ResponseEntity(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> findById(@PathVariable Long id) {
        Optional<Product> product = productService.findById(id);
        if (product.isPresent()) {
            return new ResponseEntity<Product>(product.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
        }
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product) {
        Optional<Product> currentProduct = productService.findById(product.getId());
        if(currentProduct.isPresent()) {
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
            return new ResponseEntity<Product>(currentProduct.get(), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteProduct(@PathVariable Long  id){
        Optional<Product> currentProduct = productService.findById(id);
        if(currentProduct.isPresent()){
            productService.delete(currentProduct.get().getId());
            return new ResponseEntity(HttpStatus.OK);
        }else{
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/getAllByCategory/{id}")
    public ResponseEntity<List<Product>> getAllByCategory(@PathVariable Long id){
        List<Product> productList = productService.getAllByCategoryId(id);
        if (!productList.isEmpty()){
            return new ResponseEntity<List<Product>>(productList, HttpStatus.OK );
        }else {
            return new ResponseEntity<List<Product>>(HttpStatus.NOT_FOUND);
        }
    }
   //chuc nang cua KH
    @GetMapping("/findAllByName")
    public ResponseEntity<List<Product>> findAllByName(@RequestParam String name) {
       List<Product> productList = productService.findAllByName(name);
        if (!productList.isEmpty()) {
            return new ResponseEntity<List<Product>>(productList, HttpStatus.OK);
        }else {
            return new ResponseEntity<List<Product>>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/findAllByOrigin/{origin}")
    public ResponseEntity <List<Product>> findAllByOrigin(@PathVariable String origin){
        List<Product> productList = productService.findAllByOrigin(origin);
        if (!productList.isEmpty()) {
            return new ResponseEntity<List<Product>>(productList, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<List<Product>>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/findAllByPriceBetween/{price}&&{price2}")
    public ResponseEntity<List<Product>> findAllByPriceBetween(@PathVariable Double price, @PathVariable Double price2){
        List<Product> productList = productService.findAllByPriceBetween(price,price2);
        if (!productList.isEmpty()) {
            return new ResponseEntity<List<Product>>(productList, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<List<Product>>(HttpStatus.NOT_FOUND);
        }
    }
}
