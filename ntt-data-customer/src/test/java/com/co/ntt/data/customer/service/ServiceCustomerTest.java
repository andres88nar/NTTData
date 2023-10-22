package com.co.ntt.data.customer.service;

import static com.co.ntt.data.customer.constans.CustomerConstans.HEADER_NUMBER_DOCUMENT;
import static com.co.ntt.data.customer.constans.CustomerConstans.HEADER_TYPE_DOCUMENT;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import com.co.ntt.data.customer.exception.BusinessException;
import com.co.ntt.data.customer.exception.InputValidationException;
import com.co.ntt.data.customer.exception.NotFoundException;
import com.co.ntt.data.customer.model.Customer;
import com.co.ntt.data.customer.repository.RepositoryCustomer;

import jakarta.servlet.http.HttpServletRequest;

public class ServiceCustomerTest {

	private static final String TYPE_DOCUMENT_SUCCESS = "C";
	private static final String DOCUMENT_SUCCESS = "23445322";
	private static final String TYPE_DOCUMENT_INCORRECT = "A";
	private static final String DOCUMENT_ERROR = "TEST";

	@InjectMocks
	CustomerImplement serviceCustomer;

	@Mock
	HttpServletRequest request;

	@Mock
	RepositoryCustomer repositoryCustomer;

	@BeforeEach
	public void init() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	@DisplayName("Test ServiceCustomer whit happy path")
	public void getCustomerDataTest() throws BusinessException, NotFoundException {
		Mockito.when(request.getHeader(HEADER_TYPE_DOCUMENT)).thenReturn(TYPE_DOCUMENT_SUCCESS);
		Mockito.when(request.getHeader(HEADER_NUMBER_DOCUMENT)).thenReturn(DOCUMENT_SUCCESS);
		Mockito.when(repositoryCustomer.getCustomer(TYPE_DOCUMENT_SUCCESS, DOCUMENT_SUCCESS))
				.thenReturn(new Customer());
		ResponseEntity<Object> response = serviceCustomer.getCustomerData(request);
		assertNotNull(response);
	}

	@Test
	@DisplayName("Test ServiceCustomer whitout header type_document")
	public void getCustomerDataWhitoutTypeDocumentTest() throws BusinessException, NotFoundException {
		Mockito.when(request.getHeader(HEADER_NUMBER_DOCUMENT)).thenReturn(DOCUMENT_SUCCESS);
		Mockito.when(repositoryCustomer.getCustomer(TYPE_DOCUMENT_SUCCESS, DOCUMENT_SUCCESS))
				.thenReturn(new Customer());
		Assertions.assertThrows(BusinessException.class, () -> serviceCustomer.getCustomerData(request));
	}

	@Test
	@DisplayName("Test ServiceCustomer whitout header document")
	public void getCustomerDataWhitoutDocumentTest() throws BusinessException, NotFoundException {
		Mockito.when(request.getHeader(HEADER_TYPE_DOCUMENT)).thenReturn(TYPE_DOCUMENT_SUCCESS);
		Mockito.when(repositoryCustomer.getCustomer(TYPE_DOCUMENT_SUCCESS, DOCUMENT_SUCCESS))
				.thenReturn(new Customer());
		Assertions.assertThrows(BusinessException.class, () -> serviceCustomer.getCustomerData(request));
	}
	
	@Test
	@DisplayName("Test ServiceCustomer when return a Customer null")
	public void getCustomerDataNullCustomerTest() throws BusinessException, NotFoundException {
		Mockito.when(request.getHeader(HEADER_TYPE_DOCUMENT)).thenReturn(TYPE_DOCUMENT_SUCCESS);
		Mockito.when(request.getHeader(HEADER_NUMBER_DOCUMENT)).thenReturn(DOCUMENT_SUCCESS);
		Mockito.when(repositoryCustomer.getCustomer(TYPE_DOCUMENT_SUCCESS, DOCUMENT_SUCCESS)).thenReturn(null);
		Assertions.assertThrows(NotFoundException.class, () -> serviceCustomer.getCustomerData(request));
	}
	
	@Test
	@DisplayName("Test ServiceCustomer when type_document has a incorrect calue")
	public void getCustomerDataTypeDocumentIncorrectTest() throws BusinessException, NotFoundException {
		Mockito.when(request.getHeader(HEADER_TYPE_DOCUMENT)).thenReturn(TYPE_DOCUMENT_INCORRECT);
		Mockito.when(request.getHeader(HEADER_NUMBER_DOCUMENT)).thenReturn(DOCUMENT_SUCCESS);
		Assertions.assertThrows(InputValidationException.class, () -> serviceCustomer.getCustomerData(request));
	}
	
	@Test
	@DisplayName("Test ServiceCustomer when document has a incorrect calue")
	public void getCustomerDataDocumentIncorrectTest() throws BusinessException, NotFoundException {
		Mockito.when(request.getHeader(HEADER_TYPE_DOCUMENT)).thenReturn(TYPE_DOCUMENT_INCORRECT);
		Mockito.when(request.getHeader(HEADER_NUMBER_DOCUMENT)).thenReturn(DOCUMENT_ERROR);
		Assertions.assertThrows(InputValidationException.class, () -> serviceCustomer.getCustomerData(request));
	}

}
