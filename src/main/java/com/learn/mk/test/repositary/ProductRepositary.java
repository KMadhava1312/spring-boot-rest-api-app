package com.learn.mk.test.repositary;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.mk.test.entity.Product;


public interface ProductRepositary extends JpaRepository<Product, Long> {
	
	public Product findByName(String productName);

}
