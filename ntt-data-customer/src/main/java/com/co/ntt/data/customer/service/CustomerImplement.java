package com.co.ntt.data.customer.service;

import static com.co.ntt.data.customer.constans.CustomerConstans.HEADER_NUMBER_DOCUMENT;
import static com.co.ntt.data.customer.constans.CustomerConstans.HEADER_TYPE_DOCUMENT;
import static com.co.ntt.data.customer.constans.CustomerConstans.REGEX_NUM;
import static com.co.ntt.data.customer.constans.CustomerConstans.SEVERITY_SUCCESS;
import static com.co.ntt.data.customer.constans.CustomerConstans.STATUS_DESC_SUCCESS;
import static com.co.ntt.data.customer.constans.CustomerConstans.SUCCESS_STATUS;
import static com.co.ntt.data.customer.constans.CustomerConstans.TYPEDOCUMENT;
import static com.co.ntt.data.customer.constans.ErrorMessage.ERROR_HEADER_NUMBER_DOCUMENT;
import static com.co.ntt.data.customer.constans.ErrorMessage.ERROR_HEADER_NUM_DOCUMENT_VALIDATE;
import static com.co.ntt.data.customer.constans.ErrorMessage.ERROR_HEADER_TYPE_DOCUMENT;
import static com.co.ntt.data.customer.constans.ErrorMessage.ERROR_HEADER_TYPE_DOCUMENT_VALIDATE;
import static com.co.ntt.data.customer.constans.ErrorMessage.ERROR_MSN_NOT_FOUND;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.co.ntt.data.customer.exception.BusinessException;
import com.co.ntt.data.customer.exception.InputValidationException;
import com.co.ntt.data.customer.exception.NotFoundException;
import com.co.ntt.data.customer.model.Customer;
import com.co.ntt.data.customer.model.RestResponse;
import com.co.ntt.data.customer.model.Status;
import com.co.ntt.data.customer.repository.RepositoryCustomer;

import jakarta.servlet.http.HttpServletRequest;

@Service
public class CustomerImplement implements ServiceCustomer {

	private static final Logger logger = LoggerFactory.getLogger(CustomerImplement.class);
	
	@Autowired
	RepositoryCustomer repositoryCustomer;
	
	@Override
	public ResponseEntity<Object> getCustomerData(HttpServletRequest request) throws BusinessException, NotFoundException {
		logger.trace("getCustomerData init");
		validateMantadoryHeaders(request);
		validateValuesHeaders(request);        
		Customer customer = repositoryCustomer.getCustomer(request.getHeader(HEADER_TYPE_DOCUMENT), request.getHeader(HEADER_NUMBER_DOCUMENT));
		if(customer==null) {
			throw new NotFoundException(ERROR_MSN_NOT_FOUND.replace(HEADER_NUMBER_DOCUMENT, request.getHeader(HEADER_NUMBER_DOCUMENT)));
		}		
		ResponseEntity<Object> response = new ResponseEntity<>(new RestResponse(new Status(SUCCESS_STATUS, SEVERITY_SUCCESS, STATUS_DESC_SUCCESS), customer), HttpStatus.OK);
		logger.trace("getCustomerData response: ["+response.toString()+" ]");
		return response;		
	}

	private void validateMantadoryHeaders(HttpServletRequest request) throws BusinessException {
		if (request.getHeader(HEADER_TYPE_DOCUMENT) == null || request.getHeader(HEADER_TYPE_DOCUMENT).isBlank()
				|| request.getHeader(HEADER_TYPE_DOCUMENT).isEmpty()) {
			throw new BusinessException(ERROR_HEADER_TYPE_DOCUMENT);
		}
		if (request.getHeader(HEADER_NUMBER_DOCUMENT) == null || request.getHeader(HEADER_NUMBER_DOCUMENT).isBlank()
				|| request.getHeader(HEADER_NUMBER_DOCUMENT).isEmpty()) {
			throw new BusinessException(ERROR_HEADER_NUMBER_DOCUMENT);
		}

	}

	private void validateValuesHeaders(HttpServletRequest request) throws BusinessException {
		boolean typeDoc = false;
		for (String typeDocument : TYPEDOCUMENT) {
			if (request.getHeader(HEADER_TYPE_DOCUMENT).equals(typeDocument)) {
				typeDoc = true;}}
		if (!typeDoc) {
			throw new InputValidationException(ERROR_HEADER_TYPE_DOCUMENT_VALIDATE);}	
		
		if(!request.getHeader(HEADER_NUMBER_DOCUMENT).matches(REGEX_NUM)) {
			throw new InputValidationException(ERROR_HEADER_NUM_DOCUMENT_VALIDATE);
		}	
		
	}

}
