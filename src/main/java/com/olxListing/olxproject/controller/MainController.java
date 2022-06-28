package com.olxListing.olxproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import com.olxListing.olxproject.entity.User_Registeration;
import com.olxListing.olxproject.services.UserService;

@RestController

public class MainController {
	@Autowired
	private UserService userService;
	@PostMapping("/register")
	public User_Registeration userRegisterd(@RequestBody User_Registeration b )
	{
		return userService.registerUser(b);
		
	}
	@GetMapping("/register")
	public List<User_Registeration> display()
	{
		return userService.display();
	}
	
	
	

}
