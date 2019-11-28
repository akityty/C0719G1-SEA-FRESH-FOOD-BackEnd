package com.codegym.freshfood.controller;

import com.codegym.freshfood.model.Category;
import com.codegym.freshfood.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/category")
public class CategoryController {
  @Autowired
  CategoryService categoryService;
  @PostMapping("/save")
  public ResponseEntity addCategory(@RequestBody Category category){
    categoryService.save(category);
    return new ResponseEntity(HttpStatus.OK);
  }
  @DeleteMapping("/delete/{id}")
  public ResponseEntity deleteCategory(@PathVariable Long id){
    Optional<Category> category = categoryService.findById(id);
    if(category.isPresent()){
      categoryService.delete(category.get().getId());
      return new ResponseEntity(HttpStatus.OK);
    }else {
      return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
  }
}
