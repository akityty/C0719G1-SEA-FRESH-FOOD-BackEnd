package com.codegym.freshfood.service.impl;

import com.codegym.freshfood.model.Order;
import com.codegym.freshfood.model.OrderItem;
import com.codegym.freshfood.model.Product;
import com.codegym.freshfood.model.Status;
import com.codegym.freshfood.model.signinSignup.User;
import com.codegym.freshfood.repository.OrderItemRepository;
import com.codegym.freshfood.repository.OrderRepository;
import com.codegym.freshfood.repository.ProductRepository;
import com.codegym.freshfood.repository.UserRepository;
import com.codegym.freshfood.security.jwt.JwtAuthTokenFilter;
import com.codegym.freshfood.security.jwt.JwtProvider;
import com.codegym.freshfood.security.services.UserDetailsServiceImpl;
import com.codegym.freshfood.service.OrderService;
import com.codegym.freshfood.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class OrderServiceImpl implements OrderService {
  @Autowired
  OrderItemRepository orderItemRepository;
  @Autowired
  OrderRepository orderRepository;
  @Autowired
  ProductRepository productRepository;
  @Autowired
  JwtProvider jwtProvider;
  @Autowired
  JwtAuthTokenFilter jwtAuthTokenFilter;
  @Autowired
  UserRepository userRepository;
  @Autowired
  UserDetailsServiceImpl userDetailsService;

  @Override
  public void save(Order order) {
    User currentUser = userDetailsService.getCurrentUser();
    order.setUser(currentUser);
    order.setDate(new Date());
    order.setStatus(Status.Processing);
    double total = 0;
    for (OrderItem orderItem: order.getOrderItem()) {
      Optional<Product> product = productRepository.findById(orderItem.getProductId());
      total += orderItem.getQuantity()*product.get().getPrice();
    }
    order.setTotal(total);

    Order realOrder = new Order(order.getUser(), order.getDate(), order.getStatus(),order.getOrderItem(), order.getTotal());
    orderRepository.save(realOrder);
    //tru amount
    List<OrderItem> orderItemList = order.getOrderItem();
    for (OrderItem orderItem: orderItemList) {
      Long productId =  orderItem.getProductId();
      Optional<Product> product = productRepository.findById(productId);
      Long productAmount;
      productAmount = product.get().getAmount();
      Long resultAmount;
      resultAmount = productAmount - orderItem.getQuantity();
      if(resultAmount<0){
        System.out.println("so luong khong the nho hon 0");
      }else{
        product.get().setAmount(resultAmount);
        productRepository.save(product.get());
      }
      orderItemRepository.delete(orderItem);
    }
/*
    orderRepository.save(order);
*/

  }

  @Override
  public List<Order> findAll() {
    return orderRepository.findAll();
  }

  @Override
  public Optional<Order> findById(Long id) {
    return orderRepository.findById(id);
  }

  @Override
  public void deleteOrder(Order order) {
    orderRepository.delete(order);
  }

  @Override
  public List<Order> findAllByStatus(Status status) {
    return orderRepository.findAllByStatus(status);
  }

  @Override
  public void editStatus(Order order) {
    order.setStatus(Status.Done);
    orderRepository.save(order);
  }

  @Override
  public List<Order> findAllByDateBetween(@NotBlank Date date1, @NotBlank Date date2) {
    return orderRepository.findAllByDateBetween(date1,date2);
  }

  @Override
  public Double totalOfOrders(List<Order> orderList) {
    double total = 0.d;
    for (Order order: orderList) {
     total += order.getTotal();
    }
    return total;
  }

  /*@Override
  public List<Order> findAllByDate_YearAndDate_Month(int date_year, int date_month) {
    return orderRepository.findAllByDate_YearAndDate_Month(date_year,date_month);
  }


  @Override
  public Double earningCalculate(List<Order> orderList) {
    double total;
    total = 0;
    for (Order order: orderList) {
      total += order.getTotal();
    }
    return total;
  }*/
  private String getJwt(HttpServletRequest request) {
    String authHeader = request.getHeader("Authorization");

    if (authHeader != null && authHeader.startsWith("Bearer ")) {
      return authHeader.replace("Bearer ","");
    }

    return null;
  }
}
