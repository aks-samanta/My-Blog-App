package com.myBlogApp.payloads;

import lombok.Data;

@Data
public class UserDTO {

	private Integer user_id;
	private String name;
	private String email;
	private String password;
	private String about;
}
