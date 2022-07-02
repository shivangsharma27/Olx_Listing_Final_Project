package com.olxListing.olxproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import com.olxListing.olxproject.entity.Listing;
import com.olxListing.olxproject.entity.User_Entity;
import com.olxListing.olxproject.services.UserService;

@RestController

public class MainController {
	@Autowired
	private UserService userService;
	
	@PostMapping("/register")
	public User_Entity userRegisterd(@RequestBody User_Entity b )
	{
		return userService.registerUser(b);
		
	}
	
	@GetMapping("/register")
	public List<User_Entity> display()
	{
		return userService.display();
	}
	
	@GetMapping("/register/{id}")
	public List<Listing> displayUserListings(@PathVariable("id") int id){
		return userService.displayUserListing(id);
	}
	
	@DeleteMapping("/register/{id}")
	public String deleteUserEntity(@PathVariable("id") int id) {
		return userService.deleteUserEntity(id);	
	}
}
