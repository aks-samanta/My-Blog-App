package com.myBlogApp.payloads;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class UserDTOInput {

	@NotEmpty
	@Size(min = 4, message = "Username must be atleast 4 characters long !")
	private String name;
	
	@Email(message = "Email address is not valid !")
	private String email;
	
	@NotEmpty
	@Size(min = 3, max = 10, message = "Password must be 3 to 10 characters long !")
	private String password;
	
	@NotEmpty
	private String about;
}
