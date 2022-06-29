package com.olxListing.olxproject.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
@Table(name = "listing")

public class Listing {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int id;
	String name;
	int price;
	String description;
	
	@OneToOne
	Location location;
	
	@ManyToOne
	User_Entity userEntity;
	
	public Listing() {
		super();
	}
	

	public Listing(int id, String name, int price, String description, Location location, User_Entity userEntity) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.description = description;
		this.location = location;
		this.userEntity = userEntity;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}
	
	@JsonBackReference
	public User_Entity getUserEntity() {
		return userEntity;
	}

	public void setUserEntity(User_Entity userEntity) {
		this.userEntity = userEntity;
	}

	
	
}
