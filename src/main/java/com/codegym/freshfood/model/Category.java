package com.codegym.freshfood.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "category")
public class Category {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long categoryId;

/*  @NotBlank
  @Size(min = 1, max = 20)*/
  private String name;

  @OneToMany(mappedBy = "category")
  private List<Product> products;
}
