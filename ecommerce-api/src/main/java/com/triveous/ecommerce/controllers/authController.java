package com.triveous.ecommerce.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.triveous.ecommerce.dto.jwtResponse;
import com.triveous.ecommerce.dto.loginRequest;
import com.triveous.ecommerce.dto.registerUser;
import com.triveous.ecommerce.models.user;
import com.triveous.ecommerce.security.userDetails;
import com.triveous.ecommerce.services.userService;
import com.triveous.ecommerce.utils.jwtUtil;

@RestController
@RequestMapping("/api/auth")
public class authController {
	@Autowired
	userService service;
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	jwtUtil jwtutil;
	
	@Autowired
	BCryptPasswordEncoder encoder;
	
	@GetMapping("/")
	public String handshake() {
		return "Hello";
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody loginRequest request){
		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
		String jwttoken = null;
		userDetails usr = (userDetails) authentication.getPrincipal();
		List<String> roles = usr.getAuthorities().stream().map(role->role.getAuthority()).collect(Collectors.toList());
		
		if(authentication.isAuthenticated()) {
			jwttoken = jwtutil.generateToken(request.getUsername());
			return ResponseEntity.ok(new jwtResponse(jwttoken, request.getUsername(), roles));
		}else {
			return ResponseEntity.badRequest().build();
		}
	}
	
	@PostMapping("/register")
	public ResponseEntity<?> register (@RequestBody registerUser details){
		Map<String,String> response = new HashMap<>();
		user u = new user();
		u.setFirstName(details.getFirstName());
		u.setLastName(details.getLastName());
		u.setUsername(details.getUsername());
		u.setPassword(encoder.encode(details.getPassword()));
		try {
			user saved = service.addUser(u);
			response.put("status", "Success");
			response.put("userID",Integer.toString(saved.getUserId()));
			return ResponseEntity.ok(response);
		}catch(Exception e) {
			response.put("Status", "Registration failed");
			return ResponseEntity.ok(response);
		}
	}

}
