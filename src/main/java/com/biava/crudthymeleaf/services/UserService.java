package com.biava.crudthymeleaf.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biava.crudthymeleaf.entities.User;
import com.biava.crudthymeleaf.repositories.UserRepository;
import com.biava.crudthymeleaf.services.exceptions.ResourceNotFoundException;
import com.biava.crudthymeleaf.services.exceptions.UserAlreadyExistsException;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	
	public List<User> findAll() {
		return repository.findAll();
	}
	
	public User insert(User user) {
		if(repository.findByEmail(user.getEmail()) == null) {
			return repository.save(user);
		}
		throw new UserAlreadyExistsException("The email " + user.getEmail() + " is in use!");
	}
		
	public void delete(Long id) {
		if(repository.existsById(id)) {
			repository.deleteById(id);
		}
		else {
			throw new ResourceNotFoundException("Invalid user. The Id " + id + " is invalid!");
		}
	}
	
	public User findById(Long id) {
		Optional<User> user = repository.findById(id);
		return user.orElseThrow(() -> new ResourceNotFoundException("Invalid user. The Id " + id + " is invalid!"));
	}
}
