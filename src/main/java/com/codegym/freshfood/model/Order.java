package com.codegym.freshfood.model;

import org.hibernate.annotations.NaturalId;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private Long userId;

  @NotBlank
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date date;

  @Enumerated(EnumType.STRING)
  @Column(length = 60)
  private Status status;

  @OneToMany(targetEntity = OrderItem.class)
  private List<OrderItem> orderItem;
  private Double total;

  public Order() {
  }

  public Order(Long userId, @NotBlank Date date, Status status, List<OrderItem> orderItem, @NotBlank Double total) {
    this.userId = userId;
    this.date = date;
    this.status = status;
    this.orderItem = orderItem;
    this.total = total;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public Status getStatus() {
    return status;
  }

  public void setStatus(Status status) {
    this.status = status;
  }

  public List<OrderItem> getOrderItem() {
    return orderItem;
  }

  public void setOrderItem(List<OrderItem> orderItem) {
    this.orderItem = orderItem;
  }

  public Double getTotal() {
    return total;
  }

  public void setTotal(Double total) {
    this.total = total;
  }
}
