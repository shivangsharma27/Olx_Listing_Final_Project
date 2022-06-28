package com.olxListing.olxproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.olxListing.olxproject.entity.User_Registeration;
import com.olxListing.olxproject.services.UserService;



@RestController
@RequestMapping
public class MainController {
	
	
	@Autowired
	private UserService userService;
	
	
	@PostMapping("/register")
	public  User_Registeration registerUser(@RequestBody User_Registeration b)
	{
		return userService.registerUser(b);
	}

}
