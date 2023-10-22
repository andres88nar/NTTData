package com.co.ntt.data.customer.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StatusTest {

	private static final String TEST_TEXT = "Text to teting";

	@Test
	@DisplayName("test Status for cover coverage")
	public void statusTest() {
		Status status = new Status(TEST_TEXT, TEST_TEXT, TEST_TEXT);
		status.setSeverity(TEST_TEXT);
		status.setStatusCode(TEST_TEXT);
		status.setStatusDesc(TEST_TEXT);
		assertNotNull(status.toString());
		assertEquals(status.getSeverity(), TEST_TEXT);
		assertEquals(status.getStatusCode(), TEST_TEXT);
		assertEquals(status.getStatusDesc(), TEST_TEXT);
	}

}
