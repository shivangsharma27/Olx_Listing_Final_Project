package com.olxListing.olxproject.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.olxListing.olxproject.entity.Listing;
import com.olxListing.olxproject.entity.User_Entity;



@Service
public interface UserService {
	public User_Entity registerUser(User_Entity b);

	public List<User_Entity> display();

	public User_Entity updateUser(User_Entity b);
	
	public String deleteUserEntity(int id);
	
	public List<Listing> displayUserListing(int id);

	public String deactivateListing(String email, int id);
	
}
