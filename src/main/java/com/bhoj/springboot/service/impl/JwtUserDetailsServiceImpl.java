package com.bhoj.springboot.service.impl;

import java.util.ArrayList;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * JwtUserDetailsServiceImpl class
 * 
 * @author Bhoj Sao
 *
 */
public class JwtUserDetailsServiceImpl implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		if ("bhoj".equals(username)) {
			return new User("bhoj", "$2y$10$/knR7H/by3fHstdRAo4mauCjkv9p3bIOpRDMIZOHHHPx0mcTEXzye", new ArrayList<>());
		} else {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
	}

}
