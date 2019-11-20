package com.codegym.freshfood.model;

import org.springframework.data.annotation.TypeAlias;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Table(name = "picture")
public class Picture {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @NotBlank
  private String name;

  @OneToMany(mappedBy = "picture")
  private List<Product> products;
}
