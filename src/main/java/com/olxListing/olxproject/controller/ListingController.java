package com.olxListing.olxproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.olxListing.olxproject.entity.Listing;
import com.olxListing.olxproject.entity.User_Entity;
import com.olxListing.olxproject.services.ListingService;

@RestController
public class ListingController {
	
	@Autowired
	ListingService listingService;
	
	@PostMapping("/Listings")
	public Listing addListing(@RequestBody Listing listing) {
		
		return listingService.addListing(listing);
	}
	
	@GetMapping("/Listings")
	public List<Listing> displayListings(){
		
		return listingService.displayListings();
	}
	
	@GetMapping("/Listings/{id}")
	public User_Entity displayContactDetails(@PathVariable("id") int id) {
		return listingService.displayContactDetails(id);
	}
	
	

}
