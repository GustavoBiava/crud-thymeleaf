package com.biava.crudthymeleaf.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.biava.crudthymeleaf.repositories.UserRepository;

public class UserService {

	@Autowired
	private UserRepository repository;
}
