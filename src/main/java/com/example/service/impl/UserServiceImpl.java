package com.example.service.impl;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.repository.MapId;
import org.springframework.data.cassandra.repository.support.BasicMapId;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.datastax.driver.core.utils.UUIDs;
import com.example.domain.User;
import com.example.repository.UserRepository;
import com.example.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
	public List<User> list() throws Exception {
		return (List<User>) userRepository.findAll();		
	}

	@Override
	public User addUser(User user) throws Exception {
		user.setId(UUIDs.timeBased());
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		return userRepository.save(user);
	}

	@Override
	public User updateUser(User user) throws Exception {
		return userRepository.save(user);		
	}

	@Override
	public User getById(String id) throws Exception {
		
		Map<String, Serializable> map = new HashMap<>();
		map.put("id", UUID.fromString(id));		
		MapId mapId = new BasicMapId(map);
		
		User user = userRepository.findOne(mapId);
		if(null == user) {
			throw new Exception("Resource not found");  
		}
		
		return user;
	}

	@Override
	public void deleteUser(String id) throws Exception {
		
		Map<String, Serializable> map = new HashMap<>();
		map.put("id", UUID.fromString(id));		
		MapId mapId = new BasicMapId(map);
		
		User user = userRepository.findOne(mapId);
		if(null == user) {
			throw new Exception("Resource not found");  
		}
		
		userRepository.delete(user); 
		
	}
}
