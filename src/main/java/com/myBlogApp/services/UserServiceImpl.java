package com.myBlogApp.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myBlogApp.entities.User;
import com.myBlogApp.exception.ResourceNotFoundException;
import com.myBlogApp.payloads.UserDTOInput;
import com.myBlogApp.payloads.UserDTOOutput;
import com.myBlogApp.repositories.UserRepo;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo;


	@Autowired
	private ModelMapper modelMapper;
	
	
	@Override
	public UserDTOOutput createUser(UserDTOInput userDto) {

		User user = this.dtoToUser(userDto);
		User savedUser = userRepo.save(user);

		return this.UserToDto(savedUser);
	}

	@Override
	public UserDTOOutput getUserById(Integer userId) throws ResourceNotFoundException {
		User user = userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", " id ", userId));

		return this.UserToDto(user);
	}

	@Override
	public List<UserDTOOutput> getAllUsers() {
		List<User> users = this.userRepo.findAll();

		List<UserDTOOutput> userDtos = users.stream().map(user -> this.UserToDto(user)).collect(Collectors.toList());

		return userDtos;
	}

	@Override
	public UserDTOOutput updateUser(UserDTOInput userDto, Integer userId) throws ResourceNotFoundException {
		User user = this.userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));

		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		user.setAbout(userDto.getAbout());

		User updatedUser = this.userRepo.save(user);

		return this.UserToDto(updatedUser);
	}

	@Override
	public void deleteUser(Integer userId) throws ResourceNotFoundException {
		User user = this.userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));

		this.userRepo.delete(user);

	}

	private User dtoToUser(UserDTOInput userDto) {
		
		User user = this.modelMapper.map(userDto, User.class);
		return user;
		
	}

	private UserDTOOutput UserToDto(User user) {

		UserDTOOutput userDto = this.modelMapper.map(user, UserDTOOutput.class);

		return userDto;

	}

}
