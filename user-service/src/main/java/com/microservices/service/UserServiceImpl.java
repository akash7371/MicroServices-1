package com.microservices.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.microservices.dto.LoginDto;
import com.microservices.dto.UserDetailsDto;
import com.microservices.entity.UserDetails;
import com.microservices.repo.UserDetailsRepo;

@Service
public class UserServiceImpl implements IUserService{

	
	@Autowired
	UserDetailsRepo detailsRepo;
	
	@Override
	public ResponseEntity<String> registerUser(UserDetailsDto detailsDto) {
		
		UserDetails userDetails = new UserDetails();
		userDetails.setName(detailsDto.getName());
		userDetails.setEmail(detailsDto.getEmail());
		userDetails.setPassword(detailsDto.getPassword());
		userDetails.setCity(detailsDto.getCity());
		userDetails.setGender(detailsDto.getGender());
		userDetails.setContact(detailsDto.getContact());
		
		if(detailsRepo.findById(userDetails.getEmail()).isPresent())
			return new ResponseEntity<String>("Email already existed, please try another or login", HttpStatus.BAD_REQUEST);
		else {
			detailsRepo.save(userDetails);
			return new ResponseEntity<String>("User registered Successfully....", HttpStatus.CREATED);
		}
		
	}

	@Override
	public ResponseEntity<String> userLogin(LoginDto loginDto) {
		
		
		if(detailsRepo.findByEmailAndPassword(loginDto.getEmail(), loginDto.getPassword()).isPresent()) {
			return new ResponseEntity<String>("Login Successfull..."+loginDto.getEmail(), HttpStatus.OK);
		}
		else
			return new ResponseEntity<String>("Login failed(Invalid Credential)...", HttpStatus.UNAUTHORIZED);
		
	}

	@Override
	public ResponseEntity<?> getUserById(String email) {
		// TODO Auto-generated method stub
		Optional<UserDetails> userDetails = detailsRepo.findById(email);
		if(userDetails.isPresent()) {
			UserDetailsDto detailsDto = new UserDetailsDto();
			detailsDto.setName(userDetails.get().getName());
			detailsDto.setEmail(userDetails.get().getEmail());
			detailsDto.setPassword(userDetails.get().getPassword());
			detailsDto.setCity(userDetails.get().getCity());
			detailsDto.setGender(userDetails.get().getGender());
			detailsDto.setContact(userDetails.get().getContact());
			
			return new ResponseEntity<UserDetailsDto>(detailsDto, HttpStatus.OK);
		}
		else
			return new ResponseEntity<String>("Invalid email....",HttpStatus.BAD_REQUEST);
	}

	@Override
	public ResponseEntity<String> updateUser(String email, String city) {
		
		Integer value = detailsRepo.updateUser(city, email);
		
		if(value>0)
			return new ResponseEntity<String>("User details upated successfully...", HttpStatus.OK);
		else
			return new ResponseEntity<String>("Invalid user details..", HttpStatus.BAD_REQUEST);
	}

}
