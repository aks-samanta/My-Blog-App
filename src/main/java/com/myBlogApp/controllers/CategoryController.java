package com.myBlogApp.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myBlogApp.payloads.ApiResponse;
import com.myBlogApp.payloads.CategoryDTO;
import com.myBlogApp.services.CategoryService;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	// create
	@PostMapping("/")
	public ResponseEntity<CategoryDTO> createCategory(@Valid @RequestBody CategoryDTO categoryDTO) {

		CategoryDTO createdCategory = this.categoryService.createCategory(categoryDTO);

		return new ResponseEntity<CategoryDTO>(createdCategory, HttpStatus.CREATED);
	}

	// update
	@PutMapping("/{categoryId}")
	public ResponseEntity<CategoryDTO> updateCategory(@Valid @RequestBody CategoryDTO categoryDTO,
			@PathVariable("categoryId") Integer categoryId) {

		CategoryDTO updatedCategory = this.categoryService.updateCategory(categoryDTO, categoryId);

		return new ResponseEntity<CategoryDTO>(updatedCategory, HttpStatus.OK);
	}

	// delete
	@DeleteMapping("/{categoryId}")
	public ResponseEntity<ApiResponse> deleteCategoty(@PathVariable("categoryId") Integer categoryId) {
		this.categoryService.deleteCategory(categoryId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Category Deleted Successfully", true), HttpStatus.OK);
	}

	// get
	@GetMapping("/{categoryId}")
	public ResponseEntity<CategoryDTO> getCategory(@PathVariable("categoryId") Integer categoryId) {

		return ResponseEntity.ok(this.categoryService.getCategory(categoryId));

	}

	// getAll
	@GetMapping("/")
	public ResponseEntity<List<CategoryDTO>> getAllCategories() {

		return ResponseEntity.ok(this.categoryService.getAllCategories());

	}
}
