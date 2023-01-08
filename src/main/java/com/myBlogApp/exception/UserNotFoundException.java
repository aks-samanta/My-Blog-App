package com.myBlogApp.exception;

public class UserNotFoundException extends Exception {
	public UserNotFoundException() {

	}

	public UserNotFoundException(String message) {
		super(message);
	}
}
