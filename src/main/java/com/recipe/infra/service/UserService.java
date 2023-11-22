package com.recipe.infra.service;

import org.springframework.stereotype.Service;

import com.recipe.infra.entity.UserEntity;
import com.recipe.infra.repository.UserRepository;

@Service
public class UserService {

	private final UserRepository userRepository;
	
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public UserEntity getUserById(Long id) {
		return userRepository.findById(id).orElse(null);
	}
	
}
