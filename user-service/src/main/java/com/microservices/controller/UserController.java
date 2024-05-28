package com.microservices.controller;

import org.springframework.web.bind.annotation.RestController;

import com.microservices.dto.LoginDto;
import com.microservices.dto.UserDetailsDto;
import com.microservices.service.IUserService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/service")
public class UserController {

	@Autowired
	IUserService userService;
	
	@PostMapping(path="/register", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> userRegister(@RequestBody UserDetailsDto detailsDto) {
		//TODO: process POST request
		
		return userService.registerUser(detailsDto);
	}
	
	@PostMapping(path = "/login", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> userLogin(@RequestBody LoginDto loginDto){
		
		
		return userService.userLogin(loginDto);
		
	}
	
	
	@GetMapping(path = "/getbyid/{email}")
	public ResponseEntity<?> retriveByEmail(@PathVariable String email) {
		
		return userService.getUserById(email);
		
	}
	
	@PutMapping("/update/{email}/{city}")
	public ResponseEntity<String> updateUserDetail(@PathVariable String email, @PathVariable String city){
		
		return userService.updateUser(email, city);
		
	}
	
}
