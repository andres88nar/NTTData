package com.co.ntt.data.customer.exception;

public class NotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	public NotFoundException(String shortMessage) {
		super(shortMessage);
	}
}
