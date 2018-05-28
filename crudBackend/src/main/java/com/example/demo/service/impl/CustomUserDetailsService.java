package com.example.demo.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.entities.CustomUserDetails;
import com.example.demo.entities.User;
import com.example.demo.repositories.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Optional<User> optionalUser = userRepository.findByEmail(username);
		optionalUser.orElseThrow(() -> new UsernameNotFoundException("Username not found."));
		
		return optionalUser.map(CustomUserDetails::new).get();
	}

}