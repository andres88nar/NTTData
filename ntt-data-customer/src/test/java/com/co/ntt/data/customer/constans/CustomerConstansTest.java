package com.co.ntt.data.customer.constans;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CustomerConstansTest {

	@Test
	@DisplayName("test CustomerConstans for cover coverage")
	public void customerConstansTest() {
		CustomerConstans customerConstans = new CustomerConstans();
		assertNotNull(customerConstans);
	}

}
