package com.example.service;

import java.util.List;

import com.example.domain.User;

public interface UserService {

	List<User> list() throws Exception;
	
	User addUser(User user) throws Exception;
	
	User updateUser(User user) throws Exception;
	
	User getById(String id) throws Exception;
	
	void deleteUser(String id) throws Exception;
}
