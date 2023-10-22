package com.co.ntt.data.customer.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RestResponse {

	@JsonProperty("Status")
	Status status;

	@JsonProperty("Customer")
	Customer customer;

	public RestResponse(Status status, Customer customer) {
		this.status = status;
		this.customer = customer;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "RestResponse [status=" + status + ", customer=" + customer + "]";
	}

}
