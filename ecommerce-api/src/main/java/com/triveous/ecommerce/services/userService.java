package com.triveous.ecommerce.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.triveous.ecommerce.models.user;
import com.triveous.ecommerce.repository.userRepo;

@Service
public class userService {
	@Autowired
	userRepo repo;
	
	public user addUser(user u) {
		return repo.save(u);
	}
	
	public user findUser(String username) {
		return repo.findByUsername(username);
	}
	
	public int deleteUser(int uId) {
		try {
			repo.delete(repo.findById(uId).get());
		}catch(Exception e) {
			return -1;
		}
		return 1;
	}
}
