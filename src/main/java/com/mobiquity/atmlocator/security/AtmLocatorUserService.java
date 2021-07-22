package com.mobiquity.atmlocator.security;


import com.mobiquity.atmlocator.exception.UserNameNotFoundException;

public interface AtmLocatorUserService {
	
	ServiceUser findUser(String userId) throws UserNameNotFoundException;

}
