package com.payment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.payment.entity.PaymentDetails;

public interface PaymentRepository extends JpaRepository<PaymentDetails, String> {

	PaymentDetails findByUserIdAndPassword(String userId, String password);

}
