package com.mobiquity.atmlocator.security;

import org.apache.commons.lang3.StringUtils;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;


@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

	private final UserDetailsService userDetailsService;

	public CustomAuthenticationProvider(UserDetailsService userDetailsService) {
		this.userDetailsService = userDetailsService;
	}

	@Override
	public Authentication authenticate(Authentication auth)  {
		AtmLocatoUserDetails atmLocatoUserDetails;
		if (!validateUser(auth)) {
			throw new BadCredentialsException("UserName/Password Is Invalid");
		}
		atmLocatoUserDetails = (AtmLocatoUserDetails) userDetailsService.loadUserByUsername(auth.getName().toUpperCase());
		 if(!auth.getCredentials().toString().equalsIgnoreCase(atmLocatoUserDetails.getPassword())) {
			 throw new BadCredentialsException("Password Is Invalid");
		 }
		 return new UsernamePasswordAuthenticationToken(atmLocatoUserDetails, null, atmLocatoUserDetails.getAuthorities());
		
	}
	
	public boolean validateUser(Authentication authentication) {
		try {
			String userName = authentication.getName();
			String password = authentication.getCredentials().toString();
			return (StringUtils.isNoneBlank(userName) && StringUtils.isNoneBlank(password));
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return UsernamePasswordAuthenticationToken.class.isAssignableFrom(clazz);
	}

}
