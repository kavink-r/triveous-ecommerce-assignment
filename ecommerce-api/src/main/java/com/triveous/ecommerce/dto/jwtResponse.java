package com.triveous.ecommerce.dto;

import java.util.List;

public class jwtResponse {
	private String token;
	private String type = "Bearer";
	private String username;
	private List<String> roles;
	
	public jwtResponse(String jwttoken,String username,List<String> user_roles) {
		this.token=jwttoken;
		this.username=username;
		this.roles=user_roles;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}
	
}
