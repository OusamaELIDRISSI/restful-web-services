package com.in28minutes.rest.webservices.restfulwebservices.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.in28minutes.rest.webservices.restfulwebservices.dao.UserDao;
import com.in28minutes.rest.webservices.restfulwebservices.model.JwtUserDetails;
import com.in28minutes.rest.webservices.restfulwebservices.model.UserDTO;

@Service
public class JwtInMemoryUserDetailsService implements UserDetailsService {

	@Autowired
	private UserDao userDao;

	@Autowired
	private PasswordEncoder bcryptEncoder;
	
	@Override
	public UserDetails loadUserByUsername(String username) {

		JwtUserDetails user = userDao.findByUsername(username);
		
		if (user == null) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		
		return user;
	}

	public JwtUserDetails save(UserDTO user) {
		JwtUserDetails newUser = new JwtUserDetails(user.getUsername(), bcryptEncoder.encode(user.getPassword()));
		return userDao.save(newUser);
	}

}
