package com.olxListing.olxproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.olxListing.olxproject.entity.User_Registeration;

public interface User_Repo extends JpaRepository<User_Registeration,Integer>{

}
