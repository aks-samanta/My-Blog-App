package com.myBlogApp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myBlogApp.entities.Category;
import com.myBlogApp.entities.Post;
import com.myBlogApp.entities.User;

public interface PostRepo extends JpaRepository<Post, Integer> {


	List<Post> findByUser(User user);
	
	List<Post> findByCategory(Category category);
}
