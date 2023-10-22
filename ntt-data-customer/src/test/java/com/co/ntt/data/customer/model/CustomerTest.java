package com.co.ntt.data.customer.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CustomerTest {

	private static final String TEST_TEXT = "Text to teting";

	@Test
	@DisplayName("test Customer for cover coverage")
	public void customerTest() {
		Customer customer = new Customer();
		customer.setAdderss(TEST_TEXT);
		customer.setDocument(TEST_TEXT);
		customer.setFirsName(TEST_TEXT);
		customer.setHomeCity(TEST_TEXT);
		customer.setSecondNames(TEST_TEXT);
		customer.setSecondSurnames(TEST_TEXT);
		customer.setSurnames(TEST_TEXT);
		customer.setTelephone(TEST_TEXT);
		assertNotNull(customer.toString());
		assertEquals(customer.getAdderss(), TEST_TEXT);
		assertEquals(customer.getDocument(), TEST_TEXT);
		assertEquals(customer.getFirsName(), TEST_TEXT);
		assertEquals(customer.getHomeCity(), TEST_TEXT);
		assertEquals(customer.getSecondNames(), TEST_TEXT);
		assertEquals(customer.getSecondSurnames(), TEST_TEXT);
		assertEquals(customer.getSurnames(), TEST_TEXT);
		assertEquals(customer.getTelephone(), TEST_TEXT);
	}
}
