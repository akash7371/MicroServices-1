package com.order.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.order.dto.OrderDetailsDto;
import com.order.entity.OrderDetails;
import com.order.repository.OrderRepo;

@Service
public class OrderService implements IOrderService{

	@Autowired
	OrderRepo orderRepo;
	
	@Override
	public String createOrder(OrderDetailsDto orderDetails) {
		
		OrderDetails orderData = OrderDetails.builder()
				.orderId(orderDetails.getOrderId())
				.email(orderDetails.getEmail())
				.name(orderDetails.getName())
				.amount(orderDetails.getAmount())
				.contact(orderDetails.getContact())
				.build();
		orderRepo.save(orderData);
		return "order created successfully.....";
	}

}
