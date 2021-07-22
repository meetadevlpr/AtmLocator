package com.mobiquity.atmlocator.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	private final AtmLocatorUserService atmLocatorUserService;

	public UserDetailsServiceImpl(AtmLocatorUserService atmLocatorUserService) {
		this.atmLocatorUserService = atmLocatorUserService;
	}

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException{
		ServiceUser findUser = null;
		try {
			findUser = atmLocatorUserService.findUser(userName);
		} catch (Exception e) {
			return null;
		}
		if(findUser==null) {
			return null;
		}
		List<GrantedAuthority> grants = new ArrayList<>();
		grants.add(new SimpleGrantedAuthority(findUser.getRole()));
		return new AtmLocatoUserDetails(findUser.getUserName(), findUser.getPassword(), grants);
	}

}
