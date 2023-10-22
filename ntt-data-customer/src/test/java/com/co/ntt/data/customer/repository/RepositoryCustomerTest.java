package com.co.ntt.data.customer.repository;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.co.ntt.data.customer.model.Customer;

public class RepositoryCustomerTest {

	private static final String TYPE_DOCUMENT_SUCCESS = "C";
	private static final String DOCUMENT_SUCCESS = "23445322";

	RepositoryCustomer repositoryCustomer;

	@BeforeEach
	public void init() {
		repositoryCustomer = new RepositoryCustomerImp();
	}

	@Test
	@DisplayName("Test Customer whit happy path")
	public void getCustomerTest() {
		Customer customer = repositoryCustomer.getCustomer(TYPE_DOCUMENT_SUCCESS, DOCUMENT_SUCCESS);
		assertNotNull(customer.toString());
	}

}
