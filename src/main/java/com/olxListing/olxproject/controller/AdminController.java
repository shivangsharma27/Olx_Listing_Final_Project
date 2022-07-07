package com.olxListing.olxproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.olxListing.olxproject.entity.Admin;
import com.olxListing.olxproject.entity.Listing;
import com.olxListing.olxproject.entity.Login;
import com.olxListing.olxproject.entity.User_Entity;
import com.olxListing.olxproject.services.AdminService;

@RequestMapping("/admin")
@RestController
public class AdminController {
	
	@Autowired
	AdminService adminService;
	
	// TO REGISTER AN ADMIN ----------------------
	
	@PostMapping("/register")
	public String registerAdmin(@RequestBody Admin admin) {
		return adminService.registerAdmin(admin);
	}
	
	// TO LOGIN THE ADMIN----------------------
	
		@GetMapping("/login")
		public String loginAdmin(@RequestBody Login login) {
			return adminService.loginAdmin(login);
		}
		

	// TO SEE THE LIST OF ALL THE ADMINS-------------------
		
		@GetMapping("/seeAll")
		public ResponseEntity<?> getAllAdmin(){
			return adminService.getAllAdmin();
		}
	
	// TO SEE THE LIST OF CUSTOMERS-----------------
	
		@GetMapping("/seeCustomer")
		public ResponseEntity<?> seeCustomers(){
			return adminService.seeCustomers();
		}
	
	// TO UPDATE THE DETAILS OF ANY USER-----------------
	
		@PutMapping("/updateCustomer/{email}")
		public ResponseEntity<String> updateCustomer(@PathVariable("email") String email, @RequestBody User_Entity user) {
			return adminService.updateCustomer(email, user);
		}
	
	
	// TO SEE ALL THE ACTIVE USERS ON THE PORTAL--------------
	
		@GetMapping("/seeActiveUsers")
		public ResponseEntity<?> getActiveUsers(){
			return adminService.getActiveUsers();
		}
		
	// TO SEE THE PRODUCTS LISTED BY A PARTICULAR USER-------------------
	
		@GetMapping("/getListingOfUser/{email}")
		public ResponseEntity<?> getListingOfUser(@PathVariable("email") String email){
			return adminService.getListingOfUser(email);
		}
	
	
	
	// TO SEE THE LIST OF EXPIRED PRODUCTS -------------------
	
	@GetMapping("/seeExpiredListing")
	public ResponseEntity<?> getExpiredListing(){
		return adminService.getExpiredListing();
	}
	
	
	
	// TO DEACTIVATE ANY USER-----------------
	
	@PutMapping("/deactivateCustomer/{mail}")
	public ResponseEntity<String> deactivateUser(@PathVariable("mail") String mail) {
		return adminService.deactivateUser(mail);
	}
	
	// TO ACTIVATE ANY USER---------------------
	
	@PutMapping("/activateCustomer/{mail}")
	public ResponseEntity<String> activateUser(@PathVariable("mail") String mail) {
		return adminService.activateUser(mail);
	}
	
	// TO REMOVE ANY LISTING--------------------
	
	@DeleteMapping("/removeListing/{id}")
	public String removeListing(@PathVariable("id") int id) {
		return adminService.removeListing(id);
	}
	
	// TO LOGOUT THE ADMIN---------------
	
		@GetMapping("/logout")
		public String logoutAdmin() {
			return adminService.logoutAdmin();
		}

}
