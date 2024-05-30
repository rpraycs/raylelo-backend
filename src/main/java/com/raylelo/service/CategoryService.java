package com.raylelo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raylelo.model.Category;
import com.raylelo.repository.CategoryRepository;
import com.raylelo.response.ServiceResponse;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepo;
	
	public ServiceResponse getCategories() {
		ServiceResponse serviceResponse = ServiceResponse.prepare();
		try {
			List<Category> categories = categoryRepo.findByStatus("ACTIVE");
			serviceResponse = new ServiceResponse(categories, null, true);
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return serviceResponse;
	}

}
