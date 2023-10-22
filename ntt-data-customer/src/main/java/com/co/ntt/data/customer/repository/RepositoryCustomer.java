package com.co.ntt.data.customer.repository;

import org.springframework.stereotype.Service;

import com.co.ntt.data.customer.model.Customer;

@Service
public interface RepositoryCustomer {

	public Customer getCustomer(String type_document, String document);
	
}
