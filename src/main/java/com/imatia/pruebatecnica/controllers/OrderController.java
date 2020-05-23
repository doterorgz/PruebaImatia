package com.imatia.pruebatecnica.controllers;

import com.imatia.pruebatecnica.model.dto.OrderTrackingListDTO;
import com.imatia.pruebatecnica.model.service.OrderTrackingService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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
	@ApiOperation(value = "post tracking  ")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "OK"),
			@ApiResponse(code = 400, message = "Invalid id syntax"),
			@ApiResponse(code = 500, message = "Internal server error")
	})
	public ResponseEntity<?> postTracking(@RequestBody OrderTrackingListDTO orders) {

		try {
			OrderTrackingListDTO result = trackingService.postState(orders);
			return ResponseEntity.status(HttpStatus.OK).body(result);
		} catch (Exception e) {
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}


}
