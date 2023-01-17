package com.myBlogApp.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myBlogApp.entities.Category;
import com.myBlogApp.exception.ResourceNotFoundException;
import com.myBlogApp.payloads.CategoryDTO;
import com.myBlogApp.repositories.CategoryRepo;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepo categoryRepo;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public CategoryDTO createCategory(CategoryDTO categoryDto) {

		Category category = this.modelMapper.map(categoryDto, Category.class);
		Category savedCategory = this.categoryRepo.save(category);
		return this.modelMapper.map(savedCategory, CategoryDTO.class);
	}

	@Override
	public CategoryDTO updateCategory(CategoryDTO categoryDto, Integer categoryId) {

		// converting categoryDto to Category class in order to update and persist.
		Category category = this.modelMapper.map(categoryDto, Category.class);

		Category foundCategory = this.categoryRepo.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("Category", "CategoryID", categoryId));

		foundCategory.setCategoryTitle(category.getCategoryTitle());
		foundCategory.setCategoryDescription(category.getCategoryDescription());

		Category updatedCategory = this.categoryRepo.save(foundCategory);

		// returning the updated category by converting into its dto class.
		return this.modelMapper.map(updatedCategory, CategoryDTO.class);
	}

	@Override
	public void deleteCategory(Integer categoryId) {

		Category category = this.categoryRepo.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("Category", "CategoryID", categoryId));
		this.categoryRepo.delete(category);

	}

	@Override
	public CategoryDTO getCategory(Integer categoryId) {

		Category category = this.categoryRepo.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("Category", "CategoryID", categoryId));
		return this.modelMapper.map(category, CategoryDTO.class);
	}

	@Override
	public List<CategoryDTO> getAllCategories() {

		List<Category> categories = this.categoryRepo.findAll();
		List<CategoryDTO> categoryDtos = categories.stream()
				.map((category) -> this.modelMapper.map(category, CategoryDTO.class)).collect(Collectors.toList());

		return categoryDtos;

	}

}
