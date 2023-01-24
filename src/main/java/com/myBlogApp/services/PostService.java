package com.myBlogApp.services;

import java.util.List;

import com.myBlogApp.payloads.PostDTO;

public interface PostService {

	PostDTO createPost(PostDTO postDto, Integer userId, Integer categoryId);

	PostDTO updatePost(PostDTO postDto);

	PostDTO deletePost(Integer postId);

	List<PostDTO> getAllPosts();

	PostDTO getPostById(Integer postId);

	List<PostDTO> getPostsByCategory(Integer categoryId);

	List<PostDTO> getPostsOfUser(Integer userId);

	List<PostDTO> searchPosts(String keyword);

}
