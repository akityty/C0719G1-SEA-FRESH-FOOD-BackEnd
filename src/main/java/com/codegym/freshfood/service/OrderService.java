package com.codegym.freshfood.service;

import com.codegym.freshfood.model.Order;
import org.aspectj.weaver.ast.Or;

import java.util.List;
import java.util.Optional;

public interface OrderService {
  void save(Order order);
  List<Order> findAll();
  Optional<Order> findById(Long id);
  void deleteOrder(Order order);
/*  List<Order> findAllByDate_YearAndDate_Month(int date_year, int date_month);
  Double earningCalculate(List<Order> orderList);*/

}
