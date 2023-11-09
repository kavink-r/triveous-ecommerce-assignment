package com.triveous.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.triveous.ecommerce.models.category;

@Repository
public interface categoryRepo extends JpaRepository<category, Integer> {

}
