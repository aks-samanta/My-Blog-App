package com.myBlogApp.services;

import java.util.List;

import com.myBlogApp.exception.ResourceNotFoundException;
import com.myBlogApp.payloads.UserDTOInput;
import com.myBlogApp.payloads.UserDTOOutput;

public interface UserService {

	UserDTOOutput createUser(UserDTOInput user);

	UserDTOOutput getUserById(Integer id) throws ResourceNotFoundException;

	List<UserDTOOutput> getAllUsers();

	UserDTOOutput updateUser(UserDTOInput user, Integer userId) throws ResourceNotFoundException;

	void deleteUser(Integer userId) throws ResourceNotFoundException;

}
