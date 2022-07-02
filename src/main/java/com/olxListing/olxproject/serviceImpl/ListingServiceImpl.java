package com.olxListing.olxproject.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.olxListing.olxproject.entity.Listing;
import com.olxListing.olxproject.entity.Location;
import com.olxListing.olxproject.entity.User_Entity;
import com.olxListing.olxproject.repository.Listing_Repo;
import com.olxListing.olxproject.repository.User_Repo;
import com.olxListing.olxproject.services.ListingService;

@Component
public class ListingServiceImpl implements ListingService{
	
	@Autowired
	Listing_Repo listingRepo;
	
	@Autowired
	User_Repo userRepo;
	
	@Override
	public ResponseEntity<String> addListing(Listing listing) {
		int id = listing.getUserEntity().getId();
        User_Entity user = userRepo.getById(id);
		
		if(user.isActivate() && user.isLoggedIn()) {
			 listingRepo.save(listing);
			 String msg = "Product added successfully";
			 return new ResponseEntity<String>(msg, HttpStatus.OK);
		}
		else {
			String msg = "Login to add any product...";
			return new ResponseEntity<String>(msg,HttpStatus.OK);
		}
		
	}

	@Override
	public List<Listing> displayListings() {
		return listingRepo.findAll();
	}

	@Override
	public User_Entity displayContactDetails(int id) {
		Listing listing =  listingRepo.findById(id).get();
		return listing.getUserEntity();
	}

	@Override
	public Listing updateListing(Listing listing) {
		return listingRepo.save(listing);
	}

	@Override
	public List<Listing> searchUsingCategory(String category) throws Exception {
		if(listingRepo.findBycategory(category) == null) {
			throw new Exception("No product available in the given category");
		}
		return listingRepo.findBycategory(category);
	}

	@Override
	public List<Listing> searchUsingLocation(String city) {
		List<Listing> ListOfAllLocations = listingRepo.findAll();
		List<Listing> finalLocations = new ArrayList<>();
		
		for(Listing entry : ListOfAllLocations) {
			String curr_city = entry.getLocation().getCity();
			if(curr_city.equalsIgnoreCase(city))
				finalLocations.add(entry);
		}
		
		return finalLocations;
	}

	@Override
	public List<Listing> searchUsingPrice(int price) {
		
		return listingRepo.findItemsByPrice(price);
	}

	@Override
	public List<Listing> sortListings() {
		return listingRepo.findAll(Sort.by(Sort.Direction.ASC, "price"));
		
	}

}
