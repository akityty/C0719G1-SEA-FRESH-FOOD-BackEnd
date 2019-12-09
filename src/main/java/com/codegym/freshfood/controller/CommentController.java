package com.codegym.freshfood.controller;

import com.codegym.freshfood.model.Comment;
import com.codegym.freshfood.model.Product;
import com.codegym.freshfood.service.CommentService;
import com.codegym.freshfood.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/comment", produces = MediaType.APPLICATION_JSON_VALUE)
public class CommentController {
    @Autowired
    ProductService productService;
    @Autowired
    CommentService commentService;
    @GetMapping("/list")
    public ResponseEntity<List<Comment>> getAllComments(){
        try {
            List<Comment> commentList = commentService.findAllAndSortByDate();
            return new ResponseEntity<List<Comment>>(commentList, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<List<Comment>>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/save")
    public ResponseEntity createComment(@RequestBody Comment comment){
        commentService.save(comment);
        return new ResponseEntity(HttpStatus.CREATED);
    }
    @GetMapping("/getAllByProduct/{idProduct}")
    public ResponseEntity<List<Comment>> getAllByProduct(@PathVariable Long idProduct){
        Optional<Product> product = productService.findById(idProduct);
        if(product.isPresent()){
            List<Comment> commentList = commentService.findAllByProductOrderByDate(product.get());
            return new ResponseEntity<List<Comment>>(commentList,HttpStatus.OK);
        }else{
            return new ResponseEntity<List<Comment>>(HttpStatus.NOT_FOUND   );
        }
    }
}
