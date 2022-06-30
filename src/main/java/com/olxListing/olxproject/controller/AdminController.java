package com.olxListing.olxproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.olxListing.olxproject.entity.User_Entity;
import com.olxListing.olxproject.services.AdminService;

@RequestMapping("/admin")
@RestController
public class AdminController {
	
	@Autowired
	AdminService adminService;
	
	@GetMapping("/seeCustomer")
	public ResponseEntity<List<User_Entity>> seeCustomers(){
		return adminService.seeCustomers();
	}
	
	@PutMapping("/updateCustomer/{email}")
	public String updateCustomer(@PathVariable("email") String email, @RequestBody User_Entity user) {
		return adminService.updateCustomer(email, user);
	}
	
	@PutMapping("/deactivateCustomer/{mail}")
	public String deactivateUser(@PathVariable("mail") String mail) {
		return adminService.deactivateUser(mail);
	}

}
