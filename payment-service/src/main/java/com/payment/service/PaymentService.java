package com.payment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payment.dto.NetBankingUserDetailsDto;
import com.payment.dto.PaymentLoginDetailsDto;
import com.payment.entity.PaymentDetails;
import com.payment.repository.PaymentRepository;

@Service
public class PaymentService implements IPaymentService{
	
	@Autowired
	PaymentRepository payemntRepository;

	@Override
	public String netbankingLogin(PaymentLoginDetailsDto paymentDetails) {

		PaymentDetails data =  payemntRepository.findByUserIdAndPassword(paymentDetails.getUserId(), paymentDetails.getPassword());
		
		if(data != null) {
		return "Net Banking Login Success";
		}else {
			return "Net Banking Login Failed";
		}
	}

	@Override
	public String netbankingRegister(NetBankingUserDetailsDto neBankingUserDetails) {

		PaymentDetails paymentUserData = PaymentDetails.builder().name(neBankingUserDetails.getName())
				.userId(neBankingUserDetails.getUserId()).password(neBankingUserDetails.getPassword())
				.avilabaleBalnce(neBankingUserDetails.getAvilabaleBalnce()).build();

		payemntRepository.save(paymentUserData);

		return "Netbanking User reg. Success, try Login Now";
	}

}
