package com.codegym.freshfood.service.impl;

import com.codegym.freshfood.model.Order;
import com.codegym.freshfood.repository.OrderRepository;
import com.codegym.freshfood.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class OrderServiceImpl implements OrderService {
  @Autowired
  OrderRepository orderRepository;
  @Override
  public void save(Order order) {
    orderRepository.save(order);
  }

  @Override
  public List<Order> findAll() {
    return orderRepository.findAll();
  }
}
