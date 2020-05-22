package com.imatia.pruebatecnica.controllers;

import com.imatia.pruebatecnica.model.service.OrderTrackingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.imatia.pruebatecnica.model.dto.OrderTrackingDTO;

import java.util.List;

@RestController
public class OrderController {
	@Autowired
	private OrderTrackingService trackingService;


	@PostMapping("/order/tracking")

	public ResponseEntity<Void> postTracking(@RequestBody List<OrderTrackingDTO> orders) {

		try {
			trackingService.PostState(orders);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}


}
