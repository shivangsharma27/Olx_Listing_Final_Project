package com.olxListing.olxproject.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.olxListing.olxproject.entity.Listing;
import com.olxListing.olxproject.entity.Location;
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

	@Override
	public List<Listing> searchUsingCategory(String category) throws Exception {
		if(listingRepo.findBycategory(category) == null) {
			throw new Exception("No product available in the given category");
		}
		return listingRepo.findBycategory(category);
	}

	@Override
	public List<Listing> searchUsingLocation(String city) {
//		List<Listing> resultSet = new ArrayList<>();
//		List<Listing> entrySet = listingRepo.findAll();
//		
//		for(Listing entry : entrySet) {
//			HashMap<String, String> location = entry.getLocation();
//			System.out.println(location);
//			if(location != null && location.get("city") != null) {
//				if(location.get("city").equalsIgnoreCase(city)) {
//					resultSet.add(entry);
//				}
//			}
//				
//		}
//		return resultSet;
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

}
