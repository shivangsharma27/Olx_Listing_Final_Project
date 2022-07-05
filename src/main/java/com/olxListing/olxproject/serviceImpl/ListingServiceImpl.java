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
	public ResponseEntity<List<Listing>> searchUsingCategory(String category)  {
		if(!listingRepo.findBycategory(category).isEmpty())
			return new ResponseEntity<List<Listing>>(listingRepo.findBycategory(category),HttpStatus.OK);
		else
			return new ResponseEntity<List<Listing>>(HttpStatus.BAD_REQUEST);
	}

	@Override
	public ResponseEntity<List<Listing>> searchUsingLocation(String city) {
		List<Listing> ListOfAllLocations = listingRepo.findAll();
		List<Listing> finalLocations = new ArrayList<>();
		
		for(Listing entry : ListOfAllLocations) {
			String curr_city = entry.getLocation().getCity();
			
			if(curr_city.equalsIgnoreCase(city))
				finalLocations.add(entry);
		}
		
		if(!finalLocations.isEmpty()) {
			return new ResponseEntity<List<Listing>>(finalLocations,HttpStatus.OK);
		}
		else
			return new ResponseEntity<List<Listing>>(HttpStatus.BAD_REQUEST);
		
	}

	@Override
	public ResponseEntity<List<Listing>> searchUsingPrice(int price) {
		if(!listingRepo.findItemsByPrice(price).isEmpty())
			return new ResponseEntity<List<Listing>>(listingRepo.findItemsByPrice(price),HttpStatus.OK);
		else
			return new ResponseEntity<List<Listing>>(HttpStatus.BAD_REQUEST);
	}

	@Override
	public ResponseEntity<List<Listing>> sortListings() {
		if(!listingRepo.findAll(Sort.by(Sort.Direction.ASC, "price")).isEmpty())
			return new ResponseEntity<List<Listing>>(listingRepo.findAll(Sort.by(Sort.Direction.ASC, "price")),HttpStatus.OK);
		else
			return new ResponseEntity<List<Listing>>(HttpStatus.BAD_REQUEST);
		
	}

}
