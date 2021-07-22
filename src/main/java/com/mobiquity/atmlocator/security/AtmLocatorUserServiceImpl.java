package com.mobiquity.atmlocator.security;


import com.mobiquity.atmlocator.exception.UserNameNotFoundException;
import com.mobiquity.atmlocator.repo.AtmLocatorUserServiceRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AtmLocatorUserServiceImpl implements AtmLocatorUserService {

	AtmLocatorUserServiceRepository atmLocatorUserServiceRepository;

	public AtmLocatorUserServiceImpl(AtmLocatorUserServiceRepository atmLocatorUserServiceRepository) {
		this.atmLocatorUserServiceRepository = atmLocatorUserServiceRepository;
	}

	@Override
	public ServiceUser findUser(String userId) throws UserNameNotFoundException {
		Optional<ServiceUser> findByUserName = atmLocatorUserServiceRepository.findByUserName(userId);
		return findByUserName.orElse(null);
	}

}
