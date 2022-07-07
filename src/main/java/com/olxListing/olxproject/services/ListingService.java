package com.olxListing.olxproject.services;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.olxListing.olxproject.entity.Listing;
import com.olxListing.olxproject.entity.User_Entity;

@Service
public interface ListingService {
	
	// ADD A NEW PRODUCT--------------------------
	public ResponseEntity<String> addListing(Listing listing);
	
	// DISPLAY ALL THE LISTINGS-----------------
	public ResponseEntity<?> displayListings();

	// GET CONTACT DETAILS OF THE PARTICULAR PRODUCT-------------
	public ResponseEntity<?> displayContactDetails(int id);

	// UPDATE LISTINGS DETAILS------------------
	public Listing updateListing(Listing listing);

	// SEARCH PRODUCTS ACCORDING TO CATEGORY--------------
	public ResponseEntity<?> searchUsingCategory(String category);

	// SEARCH PRODUCTS ACCORDING TO CITY--------------------
	public ResponseEntity<?> searchUsingLocation(String city);

	// SEARCH PRODUCTS LESS THAN THE ENTERED PRICE----------------
	public ResponseEntity<?> searchUsingPrice(int price);

	// SORT THE PRODUCTS IN ASCENDING ORDER BASED ON THE PRICE-------------
	public ResponseEntity<?> sortListings();

}
