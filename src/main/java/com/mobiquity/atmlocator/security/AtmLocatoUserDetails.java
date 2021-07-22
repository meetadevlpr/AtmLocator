package com.mobiquity.atmlocator.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

public class AtmLocatoUserDetails extends User{

	private static final long serialVersionUID = 7643377486418587906L;

	public AtmLocatoUserDetails(String username, String password, Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);
	}
}
