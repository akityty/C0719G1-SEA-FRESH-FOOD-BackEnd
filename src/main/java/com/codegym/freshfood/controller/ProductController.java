package com.codegym.freshfood.controller;

import com.codegym.freshfood.model.Category;
import com.codegym.freshfood.model.Picture;
import com.codegym.freshfood.model.Product;
import com.codegym.freshfood.model.Provider;
import com.codegym.freshfood.service.CategoryService;
import com.codegym.freshfood.service.PictureService;
import com.codegym.freshfood.service.ProductService;
import com.codegym.freshfood.service.ProviderService;
import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


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
}
