package com.codegym.freshfood.service;

import com.codegym.freshfood.model.Order;
import com.codegym.freshfood.model.Status;
import org.aspectj.weaver.ast.Or;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface OrderService {
  void save(Order order);
  List<Order> findAll();
  Optional<Order> findById(Long id);
  void deleteOrder(Order order);
  List<Order> findAllByStatus(Status status);
  void editStatus(Order order);
  List<Order> findAllByDateBetween(@NotBlank Date date1, @NotBlank Date date2);
  Double totalOfOrders(List<Order> orderList);
/*  List<Order> findAllByDate_YearAndDate_Month(int date_year, int date_month);
  Double earningCalculate(List<Order> orderList);*/

}
