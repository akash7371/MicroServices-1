package com.microservices.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "user_details11")
public class UserDetails {

	
	private String name;
	@Id
	private String email;
	private String password;
	private String city;
	private String gender;
	private Long contact;
}
