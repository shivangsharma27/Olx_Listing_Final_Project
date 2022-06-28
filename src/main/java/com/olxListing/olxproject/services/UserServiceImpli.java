package com.olxListing.olxproject.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.olxListing.olxproject.entity.User_Registeration;
import com.olxListing.olxproject.repository.User_Repo;



@Component
public class UserServiceImpli implements UserService {
	@Autowired
	private User_Repo userRepo;
	public User_Registeration registerUser(User_Registeration b) {
		return userRepo.save(b);
	}
		public List<User_Registeration> display()
		{
			List<User_Registeration> list=(List<User_Registeration> )userRepo.findAll();
			return list;
		}
		

}
