package com.codegym.freshfood.controller;

import com.codegym.freshfood.model.Picture;
import com.codegym.freshfood.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/picture")
public class PictureController {
  @Autowired
  PictureService pictureService;
  @GetMapping("/list")
  public ResponseEntity<List<Picture>> getAllPicture(){
    List<Picture> pictureList = pictureService.findAll();
    if(pictureList != null) {
      return new ResponseEntity<List<Picture>>(pictureList, HttpStatus.OK);
    }else{
      return new ResponseEntity<List<Picture>>(HttpStatus.NOT_FOUND);
    }
  }

  @GetMapping("/findAllByProductId/{product_id}")
  public ResponseEntity<List<Picture>> findAllByProductId(@PathVariable Long product_id){
    List<Picture> pictureList = pictureService.findAllByProductId(product_id);
    if(pictureList != null) {
      return new ResponseEntity<List<Picture>>(pictureList, HttpStatus.OK);
    }else{
      return new ResponseEntity<List<Picture>>(HttpStatus.NOT_FOUND);
    }
  }
  @PutMapping("/update/{id}")
  public ResponseEntity updatePicture(@PathVariable Long id,@RequestBody Picture picture){
    Optional<Picture> currentPicture = pictureService.findById(id);
    if(currentPicture.isPresent()){
      currentPicture.get().setName(picture.getName());
      currentPicture.get().setProduct(picture.getProduct());
      pictureService.save(picture);
      return new ResponseEntity(HttpStatus.OK);
    }else{
      return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
  }
  @GetMapping("/{id}")
  public ResponseEntity<Picture> getPicture(@PathVariable Long id){
    Optional<Picture> currentPicture = pictureService.findById(id);
    if(currentPicture.isPresent()){
      return new ResponseEntity<Picture>(currentPicture.get(), HttpStatus.OK);
    }else{
      return new ResponseEntity<Picture>(HttpStatus.NOT_FOUND);
    }
  }
  @GetMapping("/findAllByProductCategoryId/{id}")
  public ResponseEntity<List<Picture>> findAllByProductCategoryId(@PathVariable Long id){
    List<Picture> pictureList = pictureService.findAllByProduct_Category_Id(id);
    if(pictureList != null) {
      return new ResponseEntity<List<Picture>>(pictureList, HttpStatus.OK);
    }else{
      return new ResponseEntity<List<Picture>>(HttpStatus.NOT_FOUND);
    }
  }

}
