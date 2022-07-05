package com.olxListing.olxproject.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "CustomerMessages")
public class CustomerMessages {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int id;
	
	@OneToOne
	User_Entity user1;
	
	@OneToOne
	User_Entity user2;
	
	String senderEmail;
	
	String receiverMail;
	
	String message;

	public CustomerMessages() {
		super();
		// TODO Auto-generated constructor stub
	}


	public CustomerMessages(int id, User_Entity user1, User_Entity user2, String senderEmail, String receiverMail,
			String message) {
		super();
		this.id = id;
		this.user1 = user1;
		this.user2 = user2;
		this.senderEmail = senderEmail;
		this.receiverMail = receiverMail;
		this.message = message;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}

	@JsonBackReference(value = "location-movement")
	public User_Entity getUser1() {
		return user1;
	}


	public void setUser1(User_Entity user1) {
		this.user1 = user1;
	}

	@JsonBackReference
	public User_Entity getUser2() {
		return user2;
	}


	public void setUser2(User_Entity user2) {
		this.user2 = user2;
	}


	public String getsenderEmail() {
		return senderEmail;
	}


	public void setsenderEmail(String senderEmail) {
		this.senderEmail = senderEmail;
	}


	public String getreceiverMail() {
		return receiverMail;
	}


	public void setreceiverMail(String receiverMail) {
		this.receiverMail = receiverMail;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}
	

}
