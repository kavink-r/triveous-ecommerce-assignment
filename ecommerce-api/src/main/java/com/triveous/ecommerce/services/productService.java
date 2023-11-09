package com.triveous.ecommerce.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.triveous.ecommerce.models.category;
import com.triveous.ecommerce.models.product;
import com.triveous.ecommerce.repository.productRepo;

@Service
public class productService {
	@Autowired
	productRepo repo;
	
	public product addProduct(product p) {
		return repo.save(p);
	}
	
	public product findById(int pId) {
		return repo.findById(pId).get();
	}
	
	public List<product> findByCategory(int cId){
		category c = new category();
		c.setCategoryId(cId);
		return repo.findByCategory(c);
	}
	
	public int deleteProduct (int pId) {
		product p = repo.findById(pId).get();
		try {
			repo.delete(p);
		}catch(Exception e) {
			return -1;
		}
		return 1;
	}
}
