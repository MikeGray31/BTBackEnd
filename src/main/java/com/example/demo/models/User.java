package com.example.demo.models;

import javax.persistence.*;
import java.util.List;


@Entity
public class User {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long user_id;
	private String userName;
	private String screenName;
	private String password;
	@OneToMany(mappedBy = "user")
	private List<Project_User> project_users;

	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getScreenName() {
		return screenName;
	}

	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Project_User> getProject_users() {
		return project_users;
	}

	public void setProject_users(List<Project_User> project_users) {
		this.project_users = project_users;
	}
}
