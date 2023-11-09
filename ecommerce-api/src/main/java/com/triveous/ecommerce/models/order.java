package com.triveous.ecommerce.models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="cust_orders")
public class order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderId;
	private double orderAmount;
	@ManyToOne
	private user user;
	@OneToMany
	private List<product> products;
	
	public order() {
		// TODO Auto-generated constructor stub
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public double getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(double orderAmount) {
		this.orderAmount = orderAmount;
	}

	public user getUser() {
		return user;
	}

	public void setUser(user user) {
		this.user = user;
	}

	public List<product> getProducts() {
		return products;
	}

	public void setProducts(List<product> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "order [orderId=" + orderId + ", orderAmount=" + orderAmount + ", user=" + user + ", products="
				+ products + "]";
	}
	
	
}
