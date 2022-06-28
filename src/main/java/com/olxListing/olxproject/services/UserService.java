package com.olxListing.olxproject.services;

import org.springframework.stereotype.Service;

import com.olxListing.olxproject.entity.User_Registeration;

@Service
public interface UserService {
	public User_Registeration registerUser(User_Registeration b);
	
}
