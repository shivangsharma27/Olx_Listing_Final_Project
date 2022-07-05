package com.olxListing.olxproject.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.olxListing.olxproject.entity.Admin;
import com.olxListing.olxproject.entity.AdminMessages;
import com.olxListing.olxproject.entity.CustomerMessages;
import com.olxListing.olxproject.entity.User_Entity;
import com.olxListing.olxproject.repository.AdminMessagesRepo;
import com.olxListing.olxproject.repository.Admin_Repo;
import com.olxListing.olxproject.repository.CustomerMessagesRepo;
import com.olxListing.olxproject.repository.User_Repo;
import com.olxListing.olxproject.services.MessagesService;

@Component
public class MessagesServiceImpl implements MessagesService{
	
	@Autowired
	CustomerMessagesRepo customerMessagesRepo;
	
	@Autowired
	AdminMessagesRepo adminMessagesRepo;
	
	@Autowired
	User_Repo userRepo;
	
	@Autowired 
	Admin_Repo adminRepo;

	@Override
	public String addMessages(CustomerMessages cm) {
		User_Entity user1 = userRepo.findBymail(cm.getsenderEmail());
		User_Entity user2 = userRepo.findBymail(cm.getreceiverMail());
		
		cm.setUser1(user1);
		cm.setUser2(user2);
		
		customerMessagesRepo.save(cm);
		return "Message is sent successfully!";
	}

	@Override
	public String addAdminMessages(AdminMessages am) {
		Admin admin = adminRepo.findByemail(am.getadminMail());
		User_Entity user = userRepo.findBymail(am.getcustMail());
		
		am.setAdmin(admin);
		am.setUser(user);
		
		adminMessagesRepo.save(am);
		return "Message is sent successfully!";
	}

	@Override
	public List<CustomerMessages> getCustomerMessages(String email) {
		List<CustomerMessages> allMessages = customerMessagesRepo.findAll();
		List<CustomerMessages> customerMessages = new ArrayList<>();
		
		for(CustomerMessages cm : allMessages) {
			if(cm.getsenderEmail().equals(email) || cm.getreceiverMail().equals(email)) {
				customerMessages.add(cm);
			}
		}
		return customerMessages;
	}

	@Override
	public List<AdminMessages> getAdminMessages(String email) {
		List<AdminMessages> allMessages = adminMessagesRepo.findAll();
		List<AdminMessages> adminMessages = new ArrayList<>();
		
		for(AdminMessages am : allMessages) {
			if(am.getadminMail().equals(email) || am.getcustMail().equals(email)) {
				adminMessages.add(am);
			}
		}
		return adminMessages;
	}
	
}
 