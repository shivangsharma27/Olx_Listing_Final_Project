package com.olxListing.olxproject.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "AdminMessages")
public class AdminMessages {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int id;
	
	@OneToOne
	Admin admin;
	
	@OneToOne
	User_Entity user;
	
	String email1;
	
	String email2;
	
	String message;
	
	

	public AdminMessages() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public AdminMessages(int id, Admin admin, User_Entity user, String email1, String email2, String message) {
		super();
		this.id = id;
		this.admin = admin;
		this.user = user;
		this.email1 = email1;
		this.email2 = email2;
		this.message = message;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	@JsonBackReference(value = "location-movement")
	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	
	@JsonBackReference
	public User_Entity getUser() {
		return user;
	}

	public void setUser(User_Entity user) {
		this.user = user;
	}

	public String getEmail1() {
		return email1;
	}

	public void setEmail1(String email1) {
		this.email1 = email1;
	}

	public String getEmail2() {
		return email2;
	}

	public void setEmail2(String email2) {
		this.email2 = email2;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
