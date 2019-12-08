package com.codegym.freshfood.repository;

import com.codegym.freshfood.model.Order;
import com.codegym.freshfood.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> { /*
    @Query("select  n from Note  n order by  n.id desc ")data
*/
/*
    List<Order> findAllByDate_YearAndDate_Month(int date_year, int date_month);
*/
List<Order> findAllByStatus(Status status);
List<Order> findAllByDateBetween(@NotBlank Date date1, @NotBlank Date date2);
}
