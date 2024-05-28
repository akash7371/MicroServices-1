package com.order.service;

import com.order.dto.OrderDetailsDto;

public interface IOrderService {

	String createOrder(OrderDetailsDto orderDetails);

}
