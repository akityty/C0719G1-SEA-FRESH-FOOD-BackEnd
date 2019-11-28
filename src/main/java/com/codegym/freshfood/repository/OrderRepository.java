package com.codegym.freshfood.repository;

import com.codegym.freshfood.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
