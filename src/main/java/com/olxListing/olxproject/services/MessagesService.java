package com.olxListing.olxproject.services;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.olxListing.olxproject.entity.AdminMessages;
import com.olxListing.olxproject.entity.CustomerMessages;

@Service
public interface MessagesService {

	// SEND MESSAGES FROM CUSTOMER TO CUSTOMER----------------
	String addMessages(CustomerMessages cm);

	// SEND MESSAGES FROM ADMIN TO CUSTOMER----------------
	String addAdminMessages(AdminMessages am);

	// SEE ALL THE MESSAGES FROM OR TO THE CUSTOMERS-----------------
	ResponseEntity<?> getCustomerMessages(String email);

	// SEE ALL THE MESSAGES FROM OR TO THE ADMINS-----------------
	ResponseEntity<?> getAdminMessages(String email);
	
}
