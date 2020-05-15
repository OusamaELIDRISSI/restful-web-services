package com.in28minutes.rest.webservices.restfulwebservices.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.in28minutes.rest.webservices.restfulwebservices.model.JwtUserDetails;

@Repository
public interface UserDao extends CrudRepository<JwtUserDetails, Long> {
	JwtUserDetails findByUsername(String username);
}