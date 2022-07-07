package com.olxListing.olxproject.services;

import org.springframework.stereotype.Service;

import com.olxListing.olxproject.entity.Login;

@Service
public interface LoginService {

	// LOGIN USER-----------------
	public String loginUser(Login login);

	// LOGOUT THE USER BY USING EMAIL AS PATH VARIABLE--------------
	public String logoutUser(String email);

}
