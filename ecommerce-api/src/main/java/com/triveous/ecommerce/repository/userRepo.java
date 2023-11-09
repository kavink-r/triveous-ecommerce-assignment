package com.triveous.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.triveous.ecommerce.models.user;
@Repository
public interface userRepo extends JpaRepository<user, Integer> {
	
	public user findByUsername(String username);
}
