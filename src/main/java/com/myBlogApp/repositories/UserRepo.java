package com.myBlogApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myBlogApp.entities.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

}
