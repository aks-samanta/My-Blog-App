package com.myBlogApp.services;

import java.util.List;

import com.myBlogApp.exception.UserNotFoundException;
import com.myBlogApp.payloads.UserDTO;

public interface UserService {

	UserDTO createUser(UserDTO user);

	UserDTO getUserById(Integer id) throws UserNotFoundException;

	List<UserDTO> getAllUsers();

	UserDTO updateUser(UserDTO user, Integer userId) throws UserNotFoundException;

	UserDTO deleteUser(Integer userId) throws UserNotFoundException;

}
