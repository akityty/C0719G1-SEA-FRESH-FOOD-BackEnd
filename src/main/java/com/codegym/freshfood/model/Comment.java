//package com.codegym.freshfood.model;
//
//import com.codegym.freshfood.model.signinSignup.User;
//import org.springframework.format.annotation.DateTimeFormat;
//
//import javax.persistence.*;
//import javax.validation.constraints.NotBlank;
//import javax.validation.constraints.Size;
//import java.util.Date;
//
//@Entity
//@Table(name = "comment")
//public class Comment {
//
//  @Id
//  @GeneratedValue(strategy = GenerationType.IDENTITY)
//  private Long id;
//
//
///*  private User user;*/
//
//  @DateTimeFormat(pattern = "yyyy-MM-dd")
//  private Date dateComment;
//
//
//  @NotBlank
//  @Size(max = 3000)
//  private String content;
//}
