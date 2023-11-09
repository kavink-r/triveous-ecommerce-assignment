package com.triveous.ecommerce.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.triveous.ecommerce.models.cartitem;
import com.triveous.ecommerce.models.order;
import com.triveous.ecommerce.models.product;
import com.triveous.ecommerce.models.user;
import com.triveous.ecommerce.repository.orderRepo;

@Service
public class orderService {
	@Autowired
	orderRepo repo;
	
	@Autowired
	cartitemService cartService;
	
	public int placeOrder(user u) {
		List<product> products = new ArrayList<>();
		List<cartitem> cartitems = cartService.viewCart(u);
		
		if(cartitems.size()>0) {
			for(cartitem c:cartitems) {
				products.add(c.getProduct());
			}
			order o = new order();
			o.setProducts(products);
			double total = 0;
			for(product p:products) {
				total += p.getOrderQuantity()*p.getPrice();
			}
			o.setOrderAmount(total);
			o.setUser(u);
			
			try {
				repo.save(o);
				cartService.removeOrderPlaced(cartitems);
			}catch(Exception e) {
				return -1;
			}
			return 1;
		}else {
			return 0;
		}
	}
	
	public List<order> viewOrderHistory(user u){
		return repo.findByUser(u);
	}
	
	public order viewOrderId(int oId) {
		return repo.findById(oId).get();
	}
}
