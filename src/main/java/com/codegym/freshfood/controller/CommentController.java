package com.codegym.freshfood.controller;

import com.codegym.freshfood.model.Comment;
import com.codegym.freshfood.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/comment")
public class CommentController {
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
}
