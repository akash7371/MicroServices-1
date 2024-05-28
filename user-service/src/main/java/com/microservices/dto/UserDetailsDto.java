package com.microservices.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDetailsDto {

	private String name;
	private String email;
	private String password;
	private String city;
	private String gender;
	private Long contact;
}
