package com.codegym.freshfood.controller;

import com.codegym.freshfood.model.Order;
import com.codegym.freshfood.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/order")
public class OrderController {
  @Autowired
  OrderService orderService;
  @PostMapping("/save")
  public ResponseEntity createOrder(@RequestBody Order order){
    orderService.save(order);
    return new ResponseEntity(HttpStatus.CREATED);
  }
  //cc
  @GetMapping("/list")
  public ResponseEntity<List<Order>> findAllOrder(){
    List<Order> orderList = orderService.findAll();
    if(orderList != null){
      return new ResponseEntity<List<Order>>(orderList, HttpStatus.OK);
    }else{
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }
}
