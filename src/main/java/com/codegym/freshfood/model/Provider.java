package com.codegym.freshfood.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "provider")
public class Provider {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long providerId;

  @NotBlank
  @Size(min = 1, max = 20)
  private String name;

  @OneToMany(mappedBy = "provider")
  private List<Product> products;

}
