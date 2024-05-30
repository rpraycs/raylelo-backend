package com.raylelo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.raylelo.response.ServiceResponse;
import com.raylelo.service.CategoryService;

@RestController
@RequestMapping("/category")
@CrossOrigin(origins = "http://localhost:4200")
public class CategoryController {
	
	@Autowired
	private CategoryService service;
	
	@GetMapping("/categories")
	public ServiceResponse getCategories() {
		return service.getCategories();
	}

}
