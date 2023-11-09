package com.triveous.ecommerce.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class cartitem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cartitemId;
	@OneToOne
	private product product;
	@ManyToOne
	private user user;
	
	public cartitem() {
		// TODO Auto-generated constructor stub
	}

	public int getCartitemId() {
		return cartitemId;
	}

	public void setCartitemId(int cartitemId) {
		this.cartitemId = cartitemId;
	}

	public product getProduct() {
		return product;
	}

	public void setProduct(product product) {
		this.product = product;
	}

	public user getUser() {
		return user;
	}

	public void setUser(user user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "cartitem [cartitemId=" + cartitemId + ", product=" + product + ", user=" + user + "]";
	}
	
}
