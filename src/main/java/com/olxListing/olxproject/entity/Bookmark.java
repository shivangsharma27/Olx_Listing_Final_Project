package com.olxListing.olxproject.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "bookmark")
public class Bookmark {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int id;
	
	// ManytoOne mapping with user entity because 1 user can have more than 1 bookmarks.
	@ManyToOne
	User_Entity userId;
	
	//OneToOne mapping with listing entity because 1 product id in bookmark will have only 1 product details in listing
	@OneToOne
	Listing listing;

	public Bookmark() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Bookmark(int id, User_Entity userId, Listing listing) {
		super();
		this.id = id;
		this.userId = userId;
		this.listing = listing;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User_Entity getUserId() {
		return userId;
	}

	public void setUserId(User_Entity userId) {
		this.userId = userId;
	}

	public Listing getListing() {
		return listing;
	}

	public void setListing(Listing listing) {
		this.listing = listing;
	}
	
	
}
