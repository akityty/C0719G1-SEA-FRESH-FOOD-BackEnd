package com.codegym.freshfood.service.impl;

import com.codegym.freshfood.model.Comment;
import com.codegym.freshfood.repository.CommentRepository;
import com.codegym.freshfood.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CommentServiceImpl implements CommentService {
    @Autowired
    CommentRepository commentRepository;
    @Override
    public void save(Comment comment) {
        commentRepository.save(comment);
    }

    @Override
    public List<Comment> findAll() {
        return commentRepository.findAll();
    }

    @Override
    public List<Comment> findAllAndSortByDate() {
        return commentRepository.findAllAndSortByDate();
    }
}
