package com.co.ntt.data.customer.model;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RestResponseTest {

	private static final String TEST_TEXT = "Text to teting";

	@Test
	@DisplayName("test RestResponse for cover coverage")
	public void restResponseTest() {
		RestResponse restResponse = new RestResponse(new Status(TEST_TEXT, TEST_TEXT, TEST_TEXT), new Customer());
		restResponse.setStatus(new Status(TEST_TEXT, TEST_TEXT, TEST_TEXT));
		restResponse.setCustomer(new Customer());
		assertNotNull(restResponse.toString());
		assertNotNull(restResponse.getStatus());
		assertNotNull(restResponse.getCustomer());
	}
}
