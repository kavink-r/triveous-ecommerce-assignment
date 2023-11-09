package com.triveous.ecommerce.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.triveous.ecommerce.models.category;
import com.triveous.ecommerce.repository.categoryRepo;

@Service
public class categoryService {
	@Autowired
	categoryRepo repo;
	
	public List<category> getAllCategories(){
		return repo.findAll();
	}
	
	public category addCategory(category c) {
		return repo.save(c);
	}
}
