package com.myBlogApp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myBlogApp.exception.UserNotFoundException;
import com.myBlogApp.payloads.UserDTO;
import com.myBlogApp.repositories.UserRepo;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo;
	
	@Override
	public UserDTO createUser(UserDTO user) {
		userRepo.save(null);
		return null;
	}

	@Override
	public UserDTO getUserById(Integer id) throws UserNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserDTO> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDTO updateUser(UserDTO user, Integer userId) throws UserNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDTO deleteUser(Integer userId) throws UserNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	

}
