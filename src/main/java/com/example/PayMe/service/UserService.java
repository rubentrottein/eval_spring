package com.example.PayMe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.example.PayMe.model.User;
import com.example.PayMe.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	public User getUserByName(String userName) {
		return userRepository.getUserByName(userName);
	}

	public void save(User user) {
		userRepository.save(user);
		
	}
	
	/*public List<User> getContactListByUser(User user){
		userRepository.f
	}*/
	public List<User> getAllUser(){
		return (List<User>) userRepository.findAll();
	}
	
	
	public User getConnectedUser() {
		String userName = SecurityContextHolder.getContext().getAuthentication().getName();
		User user = userRepository.getUserByName(userName);
		return user;
	}

}
