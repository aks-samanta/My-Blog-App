package com.myBlogApp.services;

import java.util.List;

import com.myBlogApp.exception.ResourceNotFoundException;
import com.myBlogApp.payloads.UserDTO;

public interface UserService {

	UserDTO createUser(UserDTO user);

	UserDTO getUserById(Integer id) throws ResourceNotFoundException;

	List<UserDTO> getAllUsers();

	UserDTO updateUser(UserDTO user, Integer userId) throws ResourceNotFoundException;

	void deleteUser(Integer userId) throws ResourceNotFoundException;

}
