package com.co.ntt.data.customer.controller;

import static com.co.ntt.data.customer.constans.CustomerConstans.BAD_STATUS;
import static com.co.ntt.data.customer.constans.CustomerConstans.SEVERITY_ERROR;
import static com.co.ntt.data.customer.constans.CustomerConstans.SEVERITY_WARNING;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.co.ntt.data.customer.exception.BusinessException;
import com.co.ntt.data.customer.exception.NotFoundException;
import com.co.ntt.data.customer.model.RestStatus;
import com.co.ntt.data.customer.model.Status;
import com.co.ntt.data.customer.service.ServiceCustomer;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("nttdata-rest/")
public class Controller {

	private static final Logger logger = LoggerFactory.getLogger(Controller.class);
	
	@Autowired
	ServiceCustomer serviceCustomer;

	@GetMapping(value = "getcustomerdata", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> getInfoCustomers(HttpServletRequest request) {
		logger.info("getInfoCustomers init");
		try {
			ResponseEntity<Object> response = serviceCustomer.getCustomerData(request);
			logger.info("getInfoCustomers response: ["+response.toString()+" ]");
			return response;
		} catch (BusinessException e) {
			logger.info("getInfoCustomers response: ["+e.toString()+" ]");
			return createResponseBuilder(e.getMessage(), SEVERITY_ERROR, HttpStatus.BAD_REQUEST);
		} catch (NotFoundException e) {
			logger.info("getInfoCustomers response: ["+e.toString()+" ]");
			return createResponseBuilder(e.getMessage(), SEVERITY_WARNING, HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			logger.error("getInfoCustomers response: ["+e.toString()+" ]");
			return createResponseBuilder(HttpStatus.INTERNAL_SERVER_ERROR.name(), SEVERITY_WARNING,
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	private ResponseEntity<Object> createResponseBuilder(String message, String severity, HttpStatus status) {		
		return new ResponseEntity<>(new RestStatus(new Status(BAD_STATUS, severity, message)), status);
	}

}
