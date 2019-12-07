package com.codegym.freshfood.service;

import com.codegym.freshfood.model.Comment;
import com.codegym.freshfood.model.Product;

import java.util.List;

public interface CommentService {
    void save(Comment comment);
    List<Comment> findAll();
    List<Comment> findAllAndSortByDate();
    List<Comment> findAllByProductOrderByDate(Product product);

}
