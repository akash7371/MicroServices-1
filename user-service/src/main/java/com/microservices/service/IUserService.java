package com.microservices.service;

import org.springframework.http.ResponseEntity;

import com.microservices.dto.LoginDto;
import com.microservices.dto.UserDetailsDto;

public interface IUserService {

	ResponseEntity<String> registerUser(UserDetailsDto detailsDto);

	ResponseEntity<String> userLogin(LoginDto loginDto);

	ResponseEntity<?> getUserById(String email);

	ResponseEntity<String> updateUser(String email, String city);

}
