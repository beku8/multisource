package com.fm.multisource.security;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUserDetailsService implements UserDetailsService {
	
	private Logger logger = LoggerFactory.getLogger(getClass());

	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		
		if(username.equalsIgnoreCase("koala")){
			authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
		}
		else if(username.equalsIgnoreCase("admin")){
			authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
			authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
			
		}
		
		logger.debug("Detected authorities for user {} are:", username);
		for(GrantedAuthority authority: authorities){
			logger.debug(authority.getAuthority());
		}
		
		return new CustomUserDetails(username, null, authorities);
	}

}
