package com.codegym.freshfood.model;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "product")
public class Product {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

/*  @NotBlank
  @Size(min = 1, max = 50)*/
  private String name;

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "category_id")
  private Category category;

 /* @NotBlank
  @Max(1000)*/
  private Long amount;

 /* @NotBlank*/
  private String picture;

/*  @NotBlank
  @Size(min = 20, max = 500)*/
  private String description;

/*  @NotBlank*/
  private Double price;

/*  @NotBlank
  @Size(min = 1, max = 50)*/
  private String origin;

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "provider_id")
  private Provider provider;

  /*@NotBlank*/
  private Boolean status;

  public Product() {
  }

  public Product(@NotBlank @Size(min = 1, max = 50) String name, Category category, @NotBlank @Max(1000) Long amount, @NotBlank String picture, @NotBlank @Size(min = 20, max = 500) String description, @NotBlank Double price, @NotBlank @Size(min = 1, max = 50) String origin, Provider provider, @NotBlank Boolean status) {
    this.name = name;
    this.category = category;
    this.amount = amount;
    this.picture = picture;
    this.description = description;
    this.price = price;
    this.origin = origin;
    this.provider = provider;
    this.status = status;
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

  public Category getCategory() {
    return category;
  }

  public void setCategory(Category category) {
    this.category = category;
  }

  public Long getAmount() {
    return amount;
  }

  public void setAmount(Long amount) {
    this.amount = amount;
  }

  public String getPicture() {
    return picture;
  }

  public void setPicture(String picture) {
    this.picture = picture;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public String getOrigin() {
    return origin;
  }

  public void setOrigin(String origin) {
    this.origin = origin;
  }

  public Provider getProvider() {
    return provider;
  }

  public void setProvider(Provider provider) {
    this.provider = provider;
  }

  public Boolean getStatus() {
    return status;
  }

  public void setStatus(Boolean status) {
    this.status = status;
  }
}
