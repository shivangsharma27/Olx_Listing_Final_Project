package com.olxListing.olxproject.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.olxListing.olxproject.entity.AdminMessages;
import com.olxListing.olxproject.entity.CustomerMessages;

@Service
public interface MessagesService {

	String addMessages(CustomerMessages cm);

	String addAdminMessages(AdminMessages am);

	List<CustomerMessages> getCustomerMessages(String email);

	List<AdminMessages> getAdminMessages(String email);
	
}
