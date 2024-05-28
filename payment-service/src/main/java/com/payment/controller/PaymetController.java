package com.payment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.payment.dto.NetBankingUserDetailsDto;
import com.payment.dto.PaymentLoginDetailsDto;
import com.payment.service.IPaymentService;

@RestController
public class PaymetController {

	
	@Autowired
	IPaymentService paymentService;
	
	
	@PostMapping("/netbanking/register")
	public String netbankingRegister(@RequestBody NetBankingUserDetailsDto orderDetails) {

		return paymentService.netbankingRegister(orderDetails);
	}
	
	
	@PostMapping("/netbanking/login")
	public String netbankingLogin(@RequestBody PaymentLoginDetailsDto paymentlogin) {

		System.out.println("Netbanking Logi for user : "+paymentlogin.getUserId());
		return paymentService.netbankingLogin(paymentlogin);
	}
	

	@GetMapping("/banking/options")
	public List<String> bankingOptionsavilable() {

		
		return  List.of("CC","DC","netbanking","UPI");
	}
}
