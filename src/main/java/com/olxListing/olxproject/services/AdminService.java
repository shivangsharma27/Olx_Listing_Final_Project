package com.olxListing.olxproject.services;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.olxListing.olxproject.entity.Admin;
import com.olxListing.olxproject.entity.Listing;
import com.olxListing.olxproject.entity.Login;
import com.olxListing.olxproject.entity.User_Entity;

@Service
public interface AdminService {

	// TO REGISTER AN ADMIN ----------------------
	public String registerAdmin(Admin admin);
	
	// TO LOGIN THE ADMIN----------------------
	public String loginAdmin(Login login);
	
	// TO SEE THE LIST OF ALL THE ADMINS-------------------
	public ResponseEntity<?> getAllAdmin();
	
	// TO SEE THE LIST OF CUSTOMERS-----------------
	public ResponseEntity<?> seeCustomers();
	
	// TO UPDATE THE DETAILS OF ANY USER-----------------
	public ResponseEntity<String> updateCustomer(String email, User_Entity user);

	// TO SEE ALL THE ACTIVE USERS ON THE PORTAL--------------
	public ResponseEntity<String> activateUser(String mail);

	// TO SEE THE LIST OF EXPIRED PRODUCTS -------------------
	public ResponseEntity<?> getExpiredListing();
	
	// TO DEACTIVATE ANY USER-----------------
	public ResponseEntity<String> deactivateUser(String email);

	// TO ACTIVATE ANY USER---------------------
	public ResponseEntity<?> getActiveUsers();
	

	// TO SEE THE PRODUCTS LISTED BY A PARTICULAR USER-------------------
	public ResponseEntity<?> getListingOfUser(String email);

	// TO REMOVE ANY LISTING--------------------
	public String removeListing(int id);
	
	// TO LOGOUT THE ADMIN
    public String logoutAdmin();

	

	

	
	

}
