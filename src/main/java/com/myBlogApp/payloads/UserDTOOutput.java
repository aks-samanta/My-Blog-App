package com.myBlogApp.payloads;

import lombok.Data;

@Data
public class UserDTOOutput {

	private Integer user_id;
	private String name;
	private String email;
	private String about;
}
