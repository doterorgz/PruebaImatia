package com.imatia.pruebatecnica.model.service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import com.imatia.pruebatecnica.model.dto.OrderTrackingListDTO;
import com.imatia.pruebatecnica.model.entity.Order;
import com.imatia.pruebatecnica.model.entity.OrderState;
import com.imatia.pruebatecnica.model.repository.OrderRepository;
import com.imatia.pruebatecnica.model.repository.OrderStateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imatia.pruebatecnica.model.dto.OrderTrackingDTO;

@Service
public class OrderTrackingServiceImpl implements OrderTrackingService{
	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private OrderStateRepository orderStateRepository;

	@Autowired
	private StateMachineService stateMachineService;

	@Autowired
	private Comparator orderStateUpdateDateComparator;

	public OrderTrackingServiceImpl() {
		super();
	}

	public OrderTrackingServiceImpl(OrderRepository orderRepository) {
		super();
		this.orderRepository = orderRepository;
	}

	@Override
	public OrderTrackingListDTO postState(OrderTrackingListDTO estados) {
		OrderTrackingListDTO result = new OrderTrackingListDTO();
		List<OrderTrackingDTO> orderTrackingsResult = result.getOrderTrackings();

		for (OrderTrackingDTO orderTrackingDTO : estados.getOrderTrackings()) {
			OrderTrackingDTO updatedOrderTrackingDTO=null;
			Optional<Order> optionalOrder = orderRepository.findById(orderTrackingDTO.getOrderId());
			Order order = null;
			if (!optionalOrder.isPresent()) {
				order = registerNewOrderTracking(orderTrackingDTO);
			}
			else order = optionalOrder.get();

			updatedOrderTrackingDTO = updateOrderTracking(orderTrackingDTO, order);
			orderTrackingsResult.add(updatedOrderTrackingDTO);
		}
		return result;
	}

	private OrderTrackingDTO updateOrderTracking(OrderTrackingDTO orderTrackingDTO, Order order) {
		OrderTrackingDTO updatedOrderTrackingDTO = null;
		Optional<OrderState> optionalCurrentLastState = order.getStates()
															.stream()
															.sorted(orderStateUpdateDateComparator)
															.findFirst();
		OrderState currentLastState = null;
		if (optionalCurrentLastState.isPresent()) currentLastState = optionalCurrentLastState.get();
		if (currentLastState == null
			|| stateMachineService.isValidTransition(currentLastState.getStateId(),
													 orderTrackingDTO.getTrackingStatusId())) {
				OrderState os = new OrderState();
				os.setStateUpdateDate(orderTrackingDTO.getChangeStatusDate());
				os.setStateId(orderTrackingDTO.getTrackingStatusId());
				os.setOrderId(orderTrackingDTO.getOrderId());
				currentLastState = orderStateRepository.save(os);

				order.getStates().add(currentLastState);
		}
		updatedOrderTrackingDTO = new OrderTrackingDTO( currentLastState.getOrderId(),
														currentLastState.getStateId(),
														currentLastState.getStateUpdateDate());
		return updatedOrderTrackingDTO;
	}

	private Order registerNewOrderTracking(OrderTrackingDTO orderTrackingDTO) {
		Order newOrder = new Order();
		newOrder.setId(orderTrackingDTO.getOrderId());
		newOrder = orderRepository.save(newOrder);
		return newOrder;
	}
}
