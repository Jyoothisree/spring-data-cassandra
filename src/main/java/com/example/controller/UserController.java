package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.User;
import com.example.service.UserService;

@RestController 
public class UserController {

	UserService userService;
	
	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@RequestMapping(value="/user", method=RequestMethod.GET)
	public List<User> users() throws Exception {
		return userService.list();
	}
	
	@ResponseStatus(code=HttpStatus.CREATED)
	@RequestMapping(value="/user", method=RequestMethod.POST) 
	public void addUser(@ModelAttribute("user") User user) throws Exception {
		userService.addUser(user);
	} 
	
	@ResponseStatus(code=HttpStatus.OK)
	@RequestMapping(value="/user", method=RequestMethod.PUT) 
	public void updateUser(@ModelAttribute("user") User user) throws Exception {
		userService.updateUser(user);
	}
	
	@ResponseStatus(code=HttpStatus.OK)
	@RequestMapping(value="/user/{id}", method=RequestMethod.GET) 
	public User getUser(@PathVariable("id") String id) throws Exception {
		return userService.getById(id); 
	}
	
	@ResponseStatus(code=HttpStatus.OK)
	@RequestMapping(value="/user/{id}", method=RequestMethod.DELETE) 
	public void deleteUser(@PathVariable("id") String id) throws Exception {
		userService.deleteUser(id);
	}
	
}