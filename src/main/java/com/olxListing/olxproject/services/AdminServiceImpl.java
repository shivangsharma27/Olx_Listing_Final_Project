package com.olxListing.olxproject.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.olxListing.olxproject.entity.User_Entity;
import com.olxListing.olxproject.repository.User_Repo;

@Component
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	User_Repo userRepo;

	@Override
	public String updateCustomer(String email, User_Entity user) {
		User_Entity curr_user = userRepo.findBymail(email);
		
		if(curr_user == null) {
			return "Please enter a valid mail";
		}
		
		if(user.getName() != null)
			curr_user.setName(user.getName());
		
		if(user.getLast_name() != null)
			curr_user.setLast_name(user.getLast_name());
		
		if(user.getContact_No() != 0)
			curr_user.setContact_No(user.getContact_No());
		
		if(user.getMail() != null)
			curr_user.setMail(user.getMail());
		
		if(user.getPassword() != null)
			curr_user.setPassword(user.getPassword());
		
		
		userRepo.save(curr_user);
		
		return "User data updated Successfully!";
		
	}

	@Override
	public ResponseEntity<List<User_Entity>> seeCustomers() {
		return new ResponseEntity<List<User_Entity>>(userRepo.findAll(), HttpStatus.OK);
	}

	@Override
	public String deactivateUser(String email) {
		User_Entity user = userRepo.findBymail(email);
		user.setActivate(false);
		userRepo.save(user);
		
		return "Customer is deactivated successfully!";
	}

}
