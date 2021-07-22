package com.mobiquity.atmlocator.repo;


import com.mobiquity.atmlocator.security.ServiceUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AtmLocatorUserServiceRepository extends JpaRepository<ServiceUser, Integer> {
	
	public Optional<ServiceUser> findByUserName(String username);
}
