package com.triveous.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.triveous.ecommerce.models.order;
import com.triveous.ecommerce.models.user;
@Repository
public interface orderRepo extends JpaRepository<order, Integer>{

	public List<order> findByUser(user user);
}
