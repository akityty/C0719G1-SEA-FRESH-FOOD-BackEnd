package com.codegym.freshfood.repository;

import com.codegym.freshfood.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
/*
    @Query("select c from Comment order by date")
*/

@Query("select c from Comment c order by c.date")
    List<Comment> findAllAndSortByDate();
}
