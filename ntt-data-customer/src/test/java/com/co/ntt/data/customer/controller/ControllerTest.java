package com.co.ntt.data.customer.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.util.ExceptionCollector;

import com.co.ntt.data.customer.exception.BusinessException;
import com.co.ntt.data.customer.exception.NotFoundException;
import com.co.ntt.data.customer.service.ServiceCustomer;

import jakarta.servlet.http.HttpServletRequest;

public class ControllerTest {

	@InjectMocks
	Controller controller;

	@Mock
	HttpServletRequest request;

	@Mock
	ServiceCustomer serviceCustomer;

	@Mock
	ResponseEntity<Object> response;

	@BeforeEach
	public void init() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	@DisplayName("Test getInfoCustomers whit Happy Path")
	public void getInfoCustomersHappyPathTest() throws BusinessException, NotFoundException {
		Mockito.when(serviceCustomer.getCustomerData(request)).thenReturn(response);
		ResponseEntity<Object> response = controller.getInfoCustomers(request);
		assertNotNull(response);
	}

	@Test
	@DisplayName("Test getInfoCustomers when retur a BusinessException")
	public void getInfoCustomersBusinessExceptionTest() throws BusinessException, NotFoundException {
		Mockito.when(serviceCustomer.getCustomerData(request)).thenThrow(BusinessException.class);
		ResponseEntity<Object> response = controller.getInfoCustomers(request);
		assertNotNull(response);
		assertEquals(response.getStatusCode(), HttpStatus.BAD_REQUEST);
	}

	@Test
	@DisplayName("Test getInfoCustomers when retur a NotFoundException")
	public void getInfoCustomersNotFoundExceptionTest() throws BusinessException, NotFoundException {
		Mockito.when(serviceCustomer.getCustomerData(request)).thenThrow(NotFoundException.class);
		ResponseEntity<Object> response = controller.getInfoCustomers(request);
		assertNotNull(response);
		assertEquals(response.getStatusCode(), HttpStatus.NOT_FOUND);
	}

	@Test
	@DisplayName("Test getInfoCustomers when retur a Exception")
	public void getInfoCustomersNotExceptionTest() throws BusinessException, NotFoundException {
		Mockito.when(serviceCustomer.getCustomerData(request)).thenThrow(NullPointerException.class);
		ResponseEntity<Object> response = controller.getInfoCustomers(request);
		assertNotNull(response);
		assertEquals(response.getStatusCode(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
