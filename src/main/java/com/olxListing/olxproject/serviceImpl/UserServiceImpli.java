package com.olxListing.olxproject.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import com.olxListing.olxproject.entity.Bookmark;
import com.olxListing.olxproject.entity.Listing;
import com.olxListing.olxproject.entity.User_Entity;
import com.olxListing.olxproject.repository.Bookmark_Repo;
import com.olxListing.olxproject.repository.Listing_Repo;
import com.olxListing.olxproject.repository.User_Repo;
import com.olxListing.olxproject.services.UserService;



@Component
public class UserServiceImpli implements UserService {
	
	@Autowired
	private User_Repo userRepo;
	
	@Autowired
	private Listing_Repo listingRepo;
	
	@Autowired Bookmark_Repo bookmarkRepo;
	
	public String registerUser(User_Entity b) {
		try {
			
				userRepo.save(b);
				return "Registration Successful";
           
			
		}catch(Exception e) {
			return "Enter details correctly";
		}
		 
		
	}
	
	public ResponseEntity<?> display()
	{
        try {
        	return ResponseEntity.ok(userRepo.findAll());
        }
        catch(Exception e){
        	return ResponseEntity.badRequest().body("No customer..");
        }
	}

	@Override
	public User_Entity updateUser(User_Entity b) {
		return userRepo.save(b);
	}

	@Override
	public String deleteUserEntity(int id) {
		userRepo.deleteById(id);
		return "User is deleted Successfully!";
	}

	@Override
	public List<Listing> displayUserListing(int id) {
		User_Entity user = userRepo.findById(id).get();
		
		return user.getListings();
	}

	@Override
	public String deactivateListing(String email, int id) {
		User_Entity user = userRepo.findBymail(email);
		if(user.isActivate() && user.isLoggedIn()) {
			Listing listing = listingRepo.findById(id).get();
			listing.setIsactivate(false);
			listingRepo.save(listing);
			
			return "Listing is deactivated successfully!";
		}
		return "User is not logged In";
	}

	@Override
	public ResponseEntity<String> addBookmark(Bookmark bookmark) {
		try {
			int user_id = bookmark.getUserId().getId();
			User_Entity user = userRepo.findById(user_id).get();
			
			if(user.isActivate() && user.isLoggedIn()) {
				bookmarkRepo.save(bookmark);
				return new ResponseEntity<String>("Bookmark is added successfully!",HttpStatus.OK);
			}
			return new ResponseEntity<String>("User is not logged In",HttpStatus.BAD_REQUEST);
		}
		catch(Exception e) {
			return new ResponseEntity<String>("Invalid details", HttpStatus.BAD_REQUEST);
		}
		
		
	}
		

}
