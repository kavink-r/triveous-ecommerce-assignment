package com.triveous.ecommerce.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.triveous.ecommerce.models.cartitem;
import com.triveous.ecommerce.models.product;
import com.triveous.ecommerce.models.user;
import com.triveous.ecommerce.repository.cartitemRepo;

@Service
public class cartitemService {
	@Autowired
	cartitemRepo repo;
	
	public cartitem addToCart(cartitem item) {
		return repo.save(item);
	}
	
	public List<cartitem> viewCart(user u){
		return repo.findByUser(u);
	}
	
	public int updateQUantity(int cartId, long q) {
		cartitem t = repo.findById(cartId).get();
		product p = t.getProduct();
		p.setOrderQuantity(q);
		t.setProduct(p);
		try {
			repo.save(t);
		}catch(Exception e) {
			return -1;
		}
		return 1;
	}
	
	public int removeItem(int cartId) {
		try {
			repo.deleteById(cartId);
		}catch(Exception e) {
			return -1;
		}
		return 1;
	}
	
	public int removeOrderPlaced(List<cartitem> items) {
		try {
			repo.deleteAll(items);
		}catch(Exception e) {
			return -1;
		}
		return 1;
	}
}
