package com.payment.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NetBankingUserDetailsDto {

	private String userId;
	private String name;
	private String password;
	private double avilabaleBalnce;

	
}
