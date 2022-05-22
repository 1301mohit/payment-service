package com.java.paymentservice.api.service;

import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.paymentservice.api.dao.PaymentRepository;
import com.java.paymentservice.api.entity.Payment;

@Service
public class PaymentService {
	
	@Autowired
	private PaymentRepository repository;
	
	public Payment doPayment(Payment payment) {
		payment.setPaymentStatus(paymentProcessing());
		payment.setTransactionId(UUID.randomUUID().toString());
		return repository.save(payment);
	}
	
	public String paymentProcessing() {
		//api should be 3rd party payment gateway(paypal, paytm...)
		return new Random().nextBoolean()?"success":"failed";
	}
	
}
