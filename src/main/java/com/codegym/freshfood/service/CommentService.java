package com.codegym.freshfood.service;

import com.codegym.freshfood.model.Comment;

import java.util.List;

public interface CommentService {
    void save(Comment comment);
    List<Comment> findAll();
    List<Comment> findAllAndSortByDate();

}
