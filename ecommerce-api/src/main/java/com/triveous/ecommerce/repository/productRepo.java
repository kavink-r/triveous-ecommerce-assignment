package com.triveous.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.triveous.ecommerce.models.category;
import com.triveous.ecommerce.models.product;

@Repository
public interface productRepo extends JpaRepository<product, Integer>{
	
	public List<product> findByCategory(category c);
}
