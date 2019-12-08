package com.codegym.freshfood.controller;

import com.codegym.freshfood.message.request.DateForm;
import com.codegym.freshfood.model.Order;
import com.codegym.freshfood.model.OrderItem;
import com.codegym.freshfood.model.Product;
import com.codegym.freshfood.model.Status;
import com.codegym.freshfood.model.signinSignup.User;
import com.codegym.freshfood.security.jwt.JwtAuthTokenFilter;
import com.codegym.freshfood.security.jwt.JwtProvider;
import com.codegym.freshfood.security.services.UserDetailsServiceImpl;
import com.codegym.freshfood.service.OrderService;
import com.codegym.freshfood.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.Optional;
// cc
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/order")
public class OrderController {
  @Autowired
  OrderService orderService;
  @Autowired
  UserService userService;
    @Autowired
    UserDetailsServiceImpl userDetailsService;
  @PostMapping("/save")
  public ResponseEntity createOrder(@RequestBody Order order){
    orderService.save(order);
    return new ResponseEntity(HttpStatus.CREATED);
  }
  //cc
  @PreAuthorize("hasRole('ADMIN')")
  @GetMapping("/list")
  public ResponseEntity<List<Order>> findAllOrder(){
    List<Order> orderList = orderService.findAll();
    if(orderList != null){
      return new ResponseEntity<List<Order>>(orderList, HttpStatus.OK);
    }else{
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }
  @GetMapping("/{id}")
  public ResponseEntity<Order> findById(@PathVariable Long id){
    Optional<Order> order = orderService.findById(id);
    if(order.isPresent()){
      return new ResponseEntity<Order>(order.get(),HttpStatus.OK);
    }else {
      return new ResponseEntity<Order>(HttpStatus.NOT_FOUND );
    }
  }
  @PreAuthorize("hasRole('ADMIN')")
  @PutMapping("/update")
  public ResponseEntity updateOrder(@RequestBody Order order){
    Optional<Order> currentOrder = orderService.findById(order.getId());
    if(currentOrder.isPresent()){
      currentOrder.get().setUser(order.getUser());
      currentOrder.get().setDate(order.getDate());
      currentOrder.get().setStatus(order.getStatus());
      currentOrder.get().setOrderItem(order.getOrderItem());
      currentOrder.get().setTotal(order.getTotal());
      orderService.save(currentOrder.get());
      return new ResponseEntity(HttpStatus.OK);
    }else {
      return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
  }
  @DeleteMapping("/delete")
  public ResponseEntity deleteOrder(@RequestBody Order order) {
    Optional<Order> currentOrder = orderService.findById(order.getId());
    if (currentOrder.isPresent()) {
      orderService.deleteOrder(currentOrder.get());
      return new ResponseEntity(HttpStatus.OK);
    } else {
      return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
  }
  @PreAuthorize("hasRole('ADMIN')")
  @GetMapping("/getOrdersByStatus/{status}")
  public ResponseEntity<List<Order>> getOrdersByStatus(@PathVariable Status status){
    List<Order> orderList = orderService.findAllByStatus(status);
    return new ResponseEntity<List<Order>>(orderList,HttpStatus.OK);
  }
  //c
  @PreAuthorize("hasRole('ADMIN') or hasRole ('USER')")
  @PutMapping("/edit/{id}")
  public ResponseEntity editStatus(@PathVariable Long id){
    Optional<Order> order = orderService.findById(id);
    if(order.isPresent()){
      orderService.editStatus(order.get());
      return new ResponseEntity(HttpStatus.OK);
    }else{
      return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
  }
  @PreAuthorize("hasRole('ADMIN')")
  @GetMapping("/getOrdersByDate")
  public ResponseEntity<List<Order>> getOrdersByDate(@RequestBody DateForm dateForm){
    List<Order> orderList = orderService.findAllByDateBetween(dateForm.getFirstDate(),dateForm.getLastDate());
    if(!orderList.isEmpty()){
      return new ResponseEntity<List<Order>>(orderList,HttpStatus.OK);
    }else{
      return new ResponseEntity<List<Order>>(HttpStatus.NOT_FOUND);
    }
  }
  @PreAuthorize("hasRole('ADMIN')")
  @GetMapping("/getTotalByOrders")
  public ResponseEntity<Double> getTotalByOrders(@RequestBody DateForm dateForm) {
    List<Order> orderList = orderService.findAllByDateBetween(dateForm.getFirstDate(),dateForm.getLastDate());
    if(!orderList.isEmpty()){
      Double total = orderService.totalOfOrders(orderList);
      return new ResponseEntity<Double>(total, HttpStatus.OK);
    }else{
      return new ResponseEntity<Double>(HttpStatus.NOT_FOUND);
    }

  }
}
