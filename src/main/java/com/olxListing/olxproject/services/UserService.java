package com.olxListing.olxproject.services;

import java.util.List;

import org.springframework.stereotype.Service;


import com.olxListing.olxproject.entity.User_Registeration;



@Service
public interface UserService {
	public User_Registeration registerUser(User_Registeration b);

	public List<User_Registeration> display();
	
}
