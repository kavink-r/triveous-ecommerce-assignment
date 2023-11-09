package com.triveous.ecommerce.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.triveous.ecommerce.models.user;
import com.triveous.ecommerce.repository.userRepo;

@Service
public class userDetailsService implements UserDetailsService {
	
	@Autowired
	userRepo repo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		if(username !=null && username !="") {
			user u = repo.findByUsername(username);
			if(u!=null) {
				userDetails usr = new userDetails(u);
				return usr;
			}else {
				throw new UsernameNotFoundException("User not found");
			}
		}else {
			throw new UsernameNotFoundException("Username not present");
		}
		
	}

}
