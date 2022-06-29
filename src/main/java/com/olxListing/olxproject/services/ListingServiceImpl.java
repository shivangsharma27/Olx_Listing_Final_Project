package com.olxListing.olxproject.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.olxListing.olxproject.entity.Listing;
import com.olxListing.olxproject.entity.User_Entity;
import com.olxListing.olxproject.repository.Listing_Repo;

@Component
public class ListingServiceImpl implements ListingService{
	
	@Autowired
	Listing_Repo listingRepo;

	@Override
	public Listing addListing(Listing listing) {
		return listingRepo.save(listing);
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

}
