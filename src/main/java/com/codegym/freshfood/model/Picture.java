package com.codegym.freshfood.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
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

//  @NotBlank
  private String name;

  @ManyToOne
  @JoinColumn(name = "product_id")
  @JsonBackReference
  private Product product;


  public Picture() {
  }

  public Picture(String name) {
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

  public Product getProduct() {
    return product;
  }

  public void setProduct(Product product) {
    this.product = product;
  }
}
