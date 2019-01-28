package com.coast896.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coast896.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
	
	Product findById(long id);
	Boolean existsByName(String name);

}
