package com.codegym.freshfood.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "category")
public class Category {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

/*  @NotBlank
  @Size(min = 1, max = 20)*/
  private String name;

  @JsonIgnore
  @OneToMany(
          cascade = CascadeType.ALL,
          orphanRemoval = true, mappedBy = "category"
  )
  private List<Product> products;

  public Category() {
  }

  public Category(String name) {
    this.name = name;
  }

  public Category(String name, List<Product> products) {
    this.name = name;
    this.products = products;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<Product> getProducts() {
    return products;
  }

  public void setProducts(List<Product> products) {
    this.products = products;
  }
}
