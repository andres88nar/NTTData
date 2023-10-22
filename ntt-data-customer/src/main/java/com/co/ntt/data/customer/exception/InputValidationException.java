package com.co.ntt.data.customer.exception;

public class InputValidationException extends BusinessException {

	private static final long serialVersionUID = 1L;

	public InputValidationException(String shortMessage) {
		super(shortMessage);
	}
}
