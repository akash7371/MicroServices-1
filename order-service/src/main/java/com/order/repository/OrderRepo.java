package com.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.order.entity.OrderDetails;

public interface OrderRepo extends JpaRepository<OrderDetails, String>{

}
