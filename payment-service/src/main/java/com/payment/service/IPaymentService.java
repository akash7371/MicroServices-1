package com.payment.service;

import com.payment.dto.NetBankingUserDetailsDto;
import com.payment.dto.PaymentLoginDetailsDto;

public interface IPaymentService {

	String netbankingRegister(NetBankingUserDetailsDto orderDetails);

	String netbankingLogin(PaymentLoginDetailsDto paymentlogin);

}
