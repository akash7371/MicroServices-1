package com.microservices.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.microservices.entity.UserDetails;

public interface UserDetailsRepo extends JpaRepository<UserDetails, String>{

	Optional<UserDetails> findByEmailAndPassword(String email, String password);
	
	@Modifying
	@Query(value = "update user_details11 set city=? where email=?", nativeQuery = true)
	Integer updateUser(String city, String email);

}
