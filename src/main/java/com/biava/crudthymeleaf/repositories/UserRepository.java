package com.biava.crudthymeleaf.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.biava.crudthymeleaf.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
}
