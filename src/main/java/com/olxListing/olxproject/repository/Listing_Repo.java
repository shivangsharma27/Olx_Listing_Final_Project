package com.olxListing.olxproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.olxListing.olxproject.entity.Listing;

@Repository
public interface Listing_Repo extends JpaRepository<Listing, Integer>{

}
