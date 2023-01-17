package com.myBlogApp.payloads;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class CategoryDTO {

	private Integer categoryId;
	@NotBlank
	@Size(min = 4)
	private String categoryTitle;
	@NotBlank
	@Size(min = 10)
	private String categoryDescription;
	
}
