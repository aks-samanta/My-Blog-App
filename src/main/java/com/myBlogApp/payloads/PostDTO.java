package com.myBlogApp.payloads;

import java.util.Date;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PostDTO {

	private String postTitle;
	private String content;
	private Date addedDate;
	private String imageName;
	private UserDTOOutput userDto;
	private CategoryDTO categoryDto;
}
