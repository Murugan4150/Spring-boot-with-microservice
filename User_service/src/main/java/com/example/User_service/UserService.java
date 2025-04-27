package com.example.User_service;


import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
	@Autowired
    private  UserRepository userRepository;
    
    public User saveUser(User user) {
    	
        return userRepository.save(user);
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).get();
    }

    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email).get();
    }
}