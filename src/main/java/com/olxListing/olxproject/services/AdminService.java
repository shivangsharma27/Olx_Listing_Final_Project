package com.olxListing.olxproject.services;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.olxListing.olxproject.entity.User_Entity;

@Service
public interface AdminService {

	public String updateCustomer(String email, User_Entity user);

	public ResponseEntity<List<User_Entity>> seeCustomers();

	public String deactivateUser(String email);

}
