package com.olxListing.olxproject.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.olxListing.olxproject.entity.Admin;
import com.olxListing.olxproject.entity.Login;
import com.olxListing.olxproject.entity.User_Entity;
import com.olxListing.olxproject.repository.Admin_Repo;
import com.olxListing.olxproject.repository.User_Repo;
import com.olxListing.olxproject.services.AdminService;

@Component
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	User_Repo userRepo;
	
	@Autowired
	Admin_Repo adminRepo;

	@Override
	public String updateCustomer(String email, User_Entity user) {
		
		Admin admin = adminRepo.findAll().get(0);
		
		if(admin.isLoggedIn()) {
			User_Entity curr_user = userRepo.findBymail(email);
			
			if(curr_user == null) {
				return "Please enter a valid mail";
			}
			
			if(user.getName() != null)
				curr_user.setName(user.getName());
			
			if(user.getLast_name() != null)
				curr_user.setLast_name(user.getLast_name());
			
			if(user.getContact_No() != 0)
				curr_user.setContact_No(user.getContact_No());
			
			if(user.getMail() != null)
				curr_user.setMail(user.getMail());
			
			if(user.getPassword() != null)
				curr_user.setPassword(user.getPassword());
			
			
			userRepo.save(curr_user);
			
			return "User data updated Successfully!";
		}
		
		return "You are not admin";
		
	}

	@Override
	public ResponseEntity<List<User_Entity>> seeCustomers() {
		Admin admin = adminRepo.findAll().get(0);

		return new ResponseEntity<List<User_Entity>>(userRepo.findAll(), HttpStatus.OK);
	}

	@Override
	public String deactivateUser(String email) {
		Admin admin = adminRepo.findAll().get(0);
		if(admin.isLoggedIn()) {
			User_Entity user = userRepo.findBymail(email);
			user.setActivate(false);
			userRepo.save(user);
			
			return "Customer is deactivated successfully!";
		}
		
		return "You are not admin!";
	}

	@Override
	public String registerAdmin(Admin admin) {
		adminRepo.save(admin);
		return "Admin is registered Successfully!";
	}

	@Override
	public String loginAdmin(Login login) {
		if(adminRepo.findByemail(login.getEmail()) != null) {
			Admin admin = adminRepo.findByemail(login.getEmail());
			
			if(login.getPassword().equals(admin.getPassword())) {
				admin.setLoggedIn(true);
				adminRepo.save(admin);
				return "Admin Logged In Successfully!";
			}
			else {
				return "Invalid Password";
			}
		}
		
		else {
			return "Invalid Credentials";
		}
	}

	@Override
	public List<Admin> getAllAdmin() {
		return adminRepo.findAll();
	}

	@Override
	public String activateUser(String mail) {
		Admin admin = adminRepo.findAll().get(0);
		if(admin.isLoggedIn()) {
			User_Entity user = userRepo.findBymail(mail);
			user.setActivate(true);
			userRepo.save(user);
			
			return "Customer is activated successfully!";
		}
		else {
			return "You are not admin";
		}
	}

	@Override
	public String logoutAdmin() {
		adminRepo.findAll().get(0).setLoggedIn(false);
		return "Logged out successfully!";
	}

}
