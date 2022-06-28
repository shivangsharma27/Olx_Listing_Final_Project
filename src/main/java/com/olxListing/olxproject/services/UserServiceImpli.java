package com.olxListing.olxproject.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.olxListing.olxproject.entity.Listing;
import com.olxListing.olxproject.entity.User_Entity;
import com.olxListing.olxproject.repository.User_Repo;



@Component
public class UserServiceImpli implements UserService {
	@Autowired
	private User_Repo userRepo;
	
	public User_Entity registerUser(User_Entity b) {
		return userRepo.save(b);
	}
	
	public List<User_Entity> display()
	{
		List<User_Entity> list=(List<User_Entity> )userRepo.findAll();
		return list;
	}

	@Override
	public User_Entity updateUser(User_Entity b) {
		return userRepo.save(b);
	}

	@Override
	public String deleteUserEntity(int id) {
		userRepo.deleteById(id);
		return "User is deleted Successfully!";
	}

	@Override
	public List<Listing> displayUserListing(int id) {
		User_Entity user = userRepo.findById(id).get();
		
		return user.getListings();
	}
		

}
