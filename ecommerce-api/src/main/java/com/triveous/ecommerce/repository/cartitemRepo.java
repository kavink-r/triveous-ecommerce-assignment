package com.triveous.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.triveous.ecommerce.models.cartitem;
import com.triveous.ecommerce.models.user;

@Repository
public interface cartitemRepo extends JpaRepository<cartitem, Integer> {
	
	public List<cartitem> findByUser(user u);
}
