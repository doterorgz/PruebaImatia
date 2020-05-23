package com.imatia.pruebatecnica.model.service;


import com.imatia.pruebatecnica.model.dto.OrderTrackingListDTO;

public interface OrderTrackingService {
	OrderTrackingListDTO postState(OrderTrackingListDTO estados);
}
