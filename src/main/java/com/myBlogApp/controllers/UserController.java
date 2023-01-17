package com.myBlogApp.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myBlogApp.payloads.ApiResponse;
import com.myBlogApp.payloads.UserDTOInput;
import com.myBlogApp.payloads.UserDTOOutput;
import com.myBlogApp.services.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private UserService userService;

	// POST - create user
	@PostMapping("/")
	public ResponseEntity<UserDTOOutput> createUser(@Valid @RequestBody UserDTOInput userDto) {

		UserDTOOutput createdUserDto = this.userService.createUser(userDto);

		return new ResponseEntity<>(createdUserDto, HttpStatus.CREATED);
	}

	// PUT - update user
	@PutMapping("/{userId}")
	public ResponseEntity<UserDTOOutput> updateUser(@Valid @RequestBody UserDTOInput userDto, @PathVariable("userId") Integer userId) {
		UserDTOOutput updatedUser = this.userService.updateUser(userDto, userId);

		return ResponseEntity.ok(updatedUser);
	}

	@DeleteMapping("/{userId}")
	public ResponseEntity<ApiResponse> deleteUser( @PathVariable("userId") Integer userId) {
		this.userService.deleteUser(userId);

		return new ResponseEntity<ApiResponse>(new ApiResponse("User Deleted Successfully", true), HttpStatus.OK);
	}

	@GetMapping("/")
	public ResponseEntity<List<UserDTOOutput>> getAllUsers() {

		return ResponseEntity.ok(this.userService.getAllUsers());

	}

	@GetMapping("/{userId}")
	public ResponseEntity<UserDTOOutput> getUser(@PathVariable("userId") Integer id) {

		return ResponseEntity.ok(this.userService.getUserById(id));

	}
}
