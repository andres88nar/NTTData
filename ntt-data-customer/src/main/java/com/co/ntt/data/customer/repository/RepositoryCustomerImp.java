package com.co.ntt.data.customer.repository;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.co.ntt.data.customer.model.Customer;

@Service
public class RepositoryCustomerImp implements RepositoryCustomer {

	private static final Logger logger = LoggerFactory.getLogger(RepositoryCustomerImp.class);
	
	ArrayList<Customer> listCustomer;

	@Override
	public Customer getCustomer(String type_document, String document) {
		logger.trace("getCustomer init");
		Customer findCustomer = null;
		if (listCustomer == null) {
			changeListCustomer();}
		for (Customer customer : listCustomer) {			
			if (customer.getDocument().equals(document)) {				
				findCustomer = customer;
			}
		}
		logger.trace("getCustomer response: ["+findCustomer.toString()+" ]");
		return findCustomer;
	}

	private void changeListCustomer() {
		Customer customer = new Customer();
		customer.setDocument("23445322");
		customer.setFirsName("Luis");
		customer.setSecondNames("Andres");
		customer.setSurnames("Narvaez");
		customer.setSecondSurnames("Narvaez");
		customer.setTelephone("3124721567");
		customer.setAdderss("Car 26 N 12-75 B/San Felipe");
		customer.setHomeCity("Pasto - Nariño");
		listCustomer= new ArrayList<>();
		listCustomer.add(customer);
	}

}
