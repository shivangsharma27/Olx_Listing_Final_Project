package com.olxListing.olxproject.services;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.olxListing.olxproject.entity.Bookmark;
import com.olxListing.olxproject.entity.Listing;
import com.olxListing.olxproject.entity.User_Entity;



@Service
public interface UserService {
	
	// REGISTER A NEW USER--------------------
	public ResponseEntity<String> registerUser(User_Entity b);

	// DISPLAY ALL CUSTOMERS------------------
	public ResponseEntity<?> display();
	
	// DELETE ANY CUSTOMER'S ACCOUNT--------------
	public ResponseEntity<String> deleteUserEntity(int id);
	
	// DISPLAY THE LISTINGS OF PARTICULAR USER-------------
	public ResponseEntity<?> displayUserListing(int id);

	// DEACTIVATE THE LISTING----------------------
	public ResponseEntity<String> deactivateListing(String email, int id);

	// BOOKMARK A PRODUCT
	public ResponseEntity<String> addBookmark(Bookmark bookmark);
	
}
