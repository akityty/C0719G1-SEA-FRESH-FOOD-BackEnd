package com.codegym.freshfood.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users")
public class user {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  @Email
  private String email;
  @Size(min = 6, max = 20)
  private String password;

  public user() {
  }

  public user(@Email String email, @Size(min = 6, max = 20) String password) {
    this.email = email;
    this.password = password;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}
