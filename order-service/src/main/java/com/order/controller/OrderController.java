package com.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.order.dto.OrderDetailsDto;
import com.order.service.IOrderService;


@RestController
public class OrderController {

	@Autowired
	IOrderService orderService;
	
	@PostMapping("/create")
	public String createOrder(@RequestBody OrderDetailsDto orderDetails) {

		return orderService.createOrder(orderDetails);
	}
}
