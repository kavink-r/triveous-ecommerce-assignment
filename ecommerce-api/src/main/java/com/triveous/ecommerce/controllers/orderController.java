package com.triveous.ecommerce.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.triveous.ecommerce.security.userDetails;
import com.triveous.ecommerce.services.orderService;

@RestController
@RequestMapping("/api/order")
public class orderController {
	@Autowired
	orderService service;
	
	@PostMapping("/placeOrder")
	public ResponseEntity<?> placeOrder(Authentication authentication){
		userDetails usr = (userDetails) authentication.getPrincipal();
		try {
			service.placeOrder(usr.getUser());
			return ResponseEntity.ok().build();
		}catch(Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}
	
	@GetMapping("/viewOrders")
	public ResponseEntity<?> viewOrderHistory(Authentication authentication){
		userDetails usr = (userDetails) authentication.getPrincipal();
		try {
			return ResponseEntity.ok(service.viewOrderHistory(usr.getUser()));
		}catch(Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> viewOrder(@PathVariable(name="id")int orderId){
		try {
			return ResponseEntity.ok(service.viewOrderId(orderId));
		}catch(Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}
}
