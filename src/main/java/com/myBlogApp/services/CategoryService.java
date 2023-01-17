package com.myBlogApp.services;

import java.util.List;

import com.myBlogApp.payloads.CategoryDTO;

public interface CategoryService {

	//create
	CategoryDTO createCategory (CategoryDTO categoryDto);
	
	//update
	CategoryDTO updateCategory (CategoryDTO categoryDto, Integer categoryId);
	
	//delete
	void deleteCategory(Integer categoryId);
	
	//get
	CategoryDTO getCategory(Integer categoryId);
	
	//getAll
	List<CategoryDTO> getAllCategories();
}
