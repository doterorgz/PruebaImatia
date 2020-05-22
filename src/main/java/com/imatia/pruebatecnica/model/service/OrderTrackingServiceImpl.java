package com.imatia.pruebatecnica.model.service;

import java.util.List;
import java.util.Optional;

import com.imatia.pruebatecnica.model.entity.Order;
import com.imatia.pruebatecnica.model.entity.OrderState;
import com.imatia.pruebatecnica.model.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imatia.pruebatecnica.model.dto.OrderTrackingDTO;
import com.imatia.pruebatecnica.model.repository.OrderStateRepository;

@Service
public class OrderTrackingServiceImpl implements OrderTrackingService{
	@Autowired
	private OrderRepository orderRepository;
	
	public OrderTrackingServiceImpl() {
		super();
	}

	public OrderTrackingServiceImpl(OrderRepository orderRepository) {
		super();
		this.orderRepository = orderRepository;
	}


	public OrderRepository getOrderRepository() {
		return orderRepository;
	}



	public void setOrderRepository(OrderRepository orderRepository) {
		this.orderRepository = orderRepository;
	}

	@Override
	public int PostState(List<OrderTrackingDTO> estados) {
		for (OrderTrackingDTO orderTrackingDTO : estados) {
			Optional<Order> order = orderRepository.findById(orderTrackingDTO.getOrderId());
			if (!order.isPresent()) {
				return -1;
			}
			else {

			}
		}
		return 0;
	}
	
	
}
