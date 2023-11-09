package com.triveous.ecommerce.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.triveous.ecommerce.models.category;
import com.triveous.ecommerce.models.product;
import com.triveous.ecommerce.services.categoryService;
import com.triveous.ecommerce.services.productService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/product")
public class productController {

	@Autowired
	productService service;
	
	@Autowired
	categoryService cService;
	
	@GetMapping("/getByCategory/{id}")
	public ResponseEntity<?> getProductsByCategory(@PathVariable(name="id")int id){
		return ResponseEntity.ok(service.findByCategory(id));
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<?> getProductById(@PathVariable(name="id")int id){
		return ResponseEntity.ok(service.findById(id));
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> addProduct(@RequestBody product p){
		try {
			service.addProduct(p);
			return ResponseEntity.ok().build();
		}catch(Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}
	
	@GetMapping("/categories")
	public ResponseEntity<?> getAllCategories(){
		return ResponseEntity.ok(cService.getAllCategories());
	}
	
	@GetMapping("/addCategory")
	public ResponseEntity<?> addCategory(@RequestBody category c){
		cService.addCategory(c);
		return ResponseEntity.ok().build();
	}
	
}
