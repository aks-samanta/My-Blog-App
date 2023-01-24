package com.myBlogApp.services;

import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myBlogApp.entities.Category;
import com.myBlogApp.entities.Post;
import com.myBlogApp.entities.User;
import com.myBlogApp.exception.ResourceNotFoundException;
import com.myBlogApp.payloads.PostDTO;
import com.myBlogApp.repositories.CategoryRepo;
import com.myBlogApp.repositories.PostRepo;
import com.myBlogApp.repositories.UserRepo;

@Service
public class PostServiceImpl implements PostService {

	@Autowired
	private PostRepo postRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private CategoryRepo categoryRepo;
	
	@Override
	public PostDTO createPost(PostDTO postDto, Integer userId, Integer categoryId) {

		User user = this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "User Id", userId));
		
		Category category = this.categoryRepo.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category", "Category Id", categoryId));
		
		
		Post post = this.modelMapper.map(postDto, Post.class);
		post.setPostTitle(postDto.getPostTitle());
		post.setCategory(category);
		post.setUser(user);
		post.setImageName("default.png");
		post.setAddedDate(new Date());
		
		return this.modelMapper.map(this.postRepo.save(post), PostDTO.class) ;
	}

	@Override
	public PostDTO updatePost(PostDTO postDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PostDTO deletePost(Integer postId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PostDTO> getAllPosts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PostDTO getPostById(Integer postId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PostDTO> getPostsByCategory(Integer categoryId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PostDTO> getPostsOfUser(Integer userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PostDTO> searchPosts(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

}
