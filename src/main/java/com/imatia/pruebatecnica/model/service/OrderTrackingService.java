package com.imatia.pruebatecnica.model.service;

import java.util.List;

import com.imatia.pruebatecnica.model.dto.OrderTrackingDTO;

public interface OrderTrackingService {
	public int PostState(List<OrderTrackingDTO> estados);
}
