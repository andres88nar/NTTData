package com.co.ntt.data.customer.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.co.ntt.data.customer.exception.BusinessException;
import com.co.ntt.data.customer.exception.NotFoundException;

import jakarta.servlet.http.HttpServletRequest;

@Service
public interface ServiceCustomer {

	public ResponseEntity<Object> getCustomerData(HttpServletRequest request) throws BusinessException, NotFoundException;
	
}
