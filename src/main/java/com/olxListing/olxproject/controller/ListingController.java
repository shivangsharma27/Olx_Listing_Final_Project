package com.olxListing.olxproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	public ResponseEntity<String> addListing(@RequestBody Listing listing){
		
		return listingService.addListing(listing);
	}
	
	@GetMapping("/Listings")
	public List<Listing> displayListings(){
		
		return listingService.displayListings();
	}
	
	@GetMapping("/searchUsingCategory/{category}")
	public List<Listing> searchUsingName(@PathVariable("category") String category) throws Exception{
		return listingService.searchUsingCategory(category) ;
	}
	
	@GetMapping("/Listings/{id}")
	public User_Entity displayContactDetails(@PathVariable("id") int id) {
		return listingService.displayContactDetails(id);
	}
	
	@GetMapping("/searchUsingLocation/{city}")
	public List<Listing> searchUsingLocation(@PathVariable("city") String city) {
		return listingService.searchUsingLocation(city);
	}
	
	@GetMapping("/searchUsingPrice/{price}")
	public List<Listing> searchUsingPrice(@PathVariable("price") int price){
		return listingService.searchUsingPrice(price);
	}
	
	@GetMapping("/sortListings")
	public List<Listing> sortListings(){
		return listingService.sortListings();
	}
	
	@PutMapping("/Listings")
	public Listing updateListing(@RequestBody Listing listing) {
		
		return listingService.updateListing(listing);
	}
	
	

}
