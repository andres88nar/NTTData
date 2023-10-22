package com.co.ntt.data.customer.model;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RestStatusTest {

	private static final String TEST_TEXT = "Text to teting";

	@Test
	@DisplayName("test RestStatus for cover coverage")
	public void restStatusTest() {
		RestStatus restStatus = new RestStatus(new Status(TEST_TEXT, TEST_TEXT, TEST_TEXT));
		restStatus.setStatus(new Status(TEST_TEXT, TEST_TEXT, TEST_TEXT));
		assertNotNull(restStatus.toString());
		assertNotNull(restStatus.getStatus());
	}
}
