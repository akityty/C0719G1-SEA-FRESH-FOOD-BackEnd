package com.codegym.freshfood.controller;

import com.codegym.freshfood.model.Category;
import com.codegym.freshfood.service.CategoryService;
import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/list")
   /* @PreAuthorize("hasRole('ADMIN')")*/
    public ResponseEntity showListCategory() {
        try {
            Iterable<Category> listCategory = categoryService.findAllCategory();
            return new ResponseEntity<Iterable<Category>>(listCategory, HttpStatus.OK);
        } catch (ExpiredJwtException e) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/add")
    public ResponseEntity addCategory(@RequestBody Category category){
            categoryService.save(category);
            return new ResponseEntity(HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Category> findById(@PathVariable Long id){
       Optional<Category> category = categoryService.findById(id);
       if(category.isPresent()){
           return new ResponseEntity<Category>(category.get(),HttpStatus.OK);
       }else{
           return new ResponseEntity<Category>(HttpStatus.NOT_FOUND);
       }
    }
}
