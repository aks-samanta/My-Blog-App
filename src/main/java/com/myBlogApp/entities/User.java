package com.myBlogApp.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "USERS")
@Data
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer user_id;
	@Column(name = "USER_NAME", nullable = false, length = 100)
	private String name;
	private String email;
	private String password;
	private String about;
}
