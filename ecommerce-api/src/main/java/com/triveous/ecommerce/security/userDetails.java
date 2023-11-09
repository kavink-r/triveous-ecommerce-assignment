package com.triveous.ecommerce.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.triveous.ecommerce.models.user;

public class userDetails implements UserDetails{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	user u;
	
	public userDetails(user usr) {
		this.u = usr;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> authorities = new ArrayList<>();
		GrantedAuthority role = new SimpleGrantedAuthority("ROLE_USER");
		authorities.add(role);
		return authorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return u.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return u.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	public user getUser() {
		return u;
	}

	
	
}
