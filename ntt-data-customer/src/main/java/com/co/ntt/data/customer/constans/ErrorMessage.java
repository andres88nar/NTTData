package com.co.ntt.data.customer.constans;

public class ErrorMessage {

	public static final String ERROR_HEADER_TYPE_DOCUMENT = "The header parameter 'type_document' can´t be null or empty.";	
	public static final String ERROR_HEADER_NUMBER_DOCUMENT = "The header parameter 'document' can´t be null or empty.";
	public static final String ERROR_HEADER_TYPE_DOCUMENT_VALIDATE = "The parameter 'type_document' is invalid, this only support: [ 'C':ID Document, 'P': Passport].";	
	public static final String ERROR_HEADER_NUM_DOCUMENT_VALIDATE = "The parameter 'document' has invalid format, this only support a numer value.";	
	public static final String ERROR_MSN_NOT_FOUND = "The customer identified with id: document was not found.";
	
}
