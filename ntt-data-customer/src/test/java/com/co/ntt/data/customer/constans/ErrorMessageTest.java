package com.co.ntt.data.customer.constans;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ErrorMessageTest {

	@Test
	@DisplayName("test ErrorMessage for cover coverage")
	public void errorMessage() {
		ErrorMessage errorMessage = new ErrorMessage();
		assertNotNull(errorMessage);
	}
}
