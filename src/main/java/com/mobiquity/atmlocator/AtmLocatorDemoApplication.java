package com.mobiquity.atmlocator;

import com.mobiquity.atmlocator.repo.AtmLocatorUserServiceRepository;
import com.mobiquity.atmlocator.security.ServiceUser;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AtmLocatorDemoApplication implements CommandLineRunner {



	public static void main(String[] args) {
		SpringApplication.run(AtmLocatorDemoApplication.class, args);
	}

	private final AtmLocatorUserServiceRepository atmLocatorUserServiceRepository;

	public AtmLocatorDemoApplication(AtmLocatorUserServiceRepository atmLocatorUserServiceRepository) {
		this.atmLocatorUserServiceRepository = atmLocatorUserServiceRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		atmLocatorUserServiceRepository.save(new ServiceUser(1001,"MEETA","ROLE_ADMIN","222222"));
		atmLocatorUserServiceRepository.save(new ServiceUser(1002,"TEST","ROLE_ADMIN","111111"));
		atmLocatorUserServiceRepository.save(new ServiceUser(1003,"PREETI","ROLE_USER","333333"));
	}
}
