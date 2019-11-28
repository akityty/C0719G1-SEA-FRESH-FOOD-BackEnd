package com.codegym.freshfood.service;

import com.codegym.freshfood.model.Order;

import java.util.List;

public interface OrderService {
  void save(Order order);
  List<Order> findAll();
}
