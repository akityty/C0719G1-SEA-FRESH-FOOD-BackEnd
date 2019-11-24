package com.codegym.freshfood.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "provider")
public class Provider {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @NotBlank
  @Size(min = 1, max = 20)
  private String name;

  @JsonIgnore
  @OneToMany(
          cascade = CascadeType.ALL,
          orphanRemoval = true,mappedBy = "provider"
  )
  private List<Product> products;

  public Provider() {
  }

  public Provider(@NotBlank @Size(min = 1, max = 20) String name) {
    this.name = name;
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
