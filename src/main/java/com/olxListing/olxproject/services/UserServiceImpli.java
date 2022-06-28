package com.olxListing.olxproject.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.olxListing.olxproject.entity.User_Registeration;
import com.olxListing.olxproject.repository.User_Repo;

@Component
public class UserServiceImpli {
	@Autowired
	private User_Repo userRepo;
	public User_Registeration registerUser(User_Registeration b) {
		return userRepo.save(b);
		
	}

}
