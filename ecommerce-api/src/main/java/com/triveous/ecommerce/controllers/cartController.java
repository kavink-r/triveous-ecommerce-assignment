package com.triveous.ecommerce.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.triveous.ecommerce.models.cartitem;
import com.triveous.ecommerce.models.product;
import com.triveous.ecommerce.security.userDetails;
import com.triveous.ecommerce.services.cartitemService;

@RestController
@RequestMapping("/api/cart")
public class cartController {
	@Autowired
	cartitemService service;
	
	@PostMapping("/addtocart")
	public ResponseEntity<?> addToCart(@RequestBody product prd, Authentication authentication){
		userDetails usr = (userDetails) authentication.getPrincipal();		
		cartitem item = new cartitem();
		item.setProduct(prd);
		item.setUser(usr.getUser());
		try {
			service.addToCart(item);
			return ResponseEntity.ok().build();
		}catch(Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}
	
	@GetMapping("/viewcart")
	public ResponseEntity<?> viewCart(Authentication authentication){
		userDetails usr = (userDetails) authentication.getPrincipal();
		return ResponseEntity.ok(service.viewCart(usr.getUser()));
	}
	
	@PatchMapping("/updateQuantity/{id}")
	public ResponseEntity<?> updateCartQuantity(@PathVariable(name="id")int cartId, @RequestParam(name="quantity")long q){
		try {
			service.updateQUantity(cartId, q);
			return ResponseEntity.ok().build();
		}catch(Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}
	
	@DeleteMapping("deleteitem/{id}")
	public ResponseEntity<?> deleteCartItem(@PathVariable(name="id")int itemId){
		try {
			service.removeItem(itemId);
			return ResponseEntity.ok().build();
		}catch(Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}
}
