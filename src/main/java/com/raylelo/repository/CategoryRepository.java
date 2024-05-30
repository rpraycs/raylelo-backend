package com.raylelo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.raylelo.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

	List<Category> findByStatus(String status);
	
	Category findByCategoryId(Long id);
}

