package com.biava.crudthymeleaf.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.biava.crudthymeleaf.entities.User;
import com.biava.crudthymeleaf.repositories.UserRepository;

@Configuration
public class DatabaseSeeding implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;
	
	
	@Override
	public void run(String... args) throws Exception {
		User user = new User(null, "Cristiano", "cristiano@email.com");
		User user2 = new User(null, "Lionel", "lionel@email.com");
		User user3 = new User(null, "Kylian", "kylian@email.com");
		
		userRepository.saveAll(Arrays.asList(user, user2, user3 ));
		
	}

}
