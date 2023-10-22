package com.co.ntt.data.customer.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Customer {

	@JsonIgnore
	private String document;

	@JsonProperty("Firs_Name")
	private String firsName;

	@JsonProperty("Second_Name")
	private String secondNames;

	@JsonProperty("Surames")
	private String surnames;

	@JsonProperty("Second_Surnames")
	private String secondSurnames;

	@JsonProperty("Telephone")
	private String telephone;

	@JsonProperty("Adderss")
	private String adderss;

	@JsonProperty("HomeCity")
	private String homeCity;

	public String getFirsName() {
		return firsName;
	}

	public void setFirsName(String firsName) {
		this.firsName = firsName;
	}

	public String getDocument() {
		return document;
	}

	public void setDocument(String document) {
		this.document = document;
	}

	public String getSecondNames() {
		return secondNames;
	}

	public void setSecondNames(String secondNames) {
		this.secondNames = secondNames;
	}

	public String getSurnames() {
		return surnames;
	}

	public void setSurnames(String surnames) {
		this.surnames = surnames;
	}

	public String getSecondSurnames() {
		return secondSurnames;
	}

	public void setSecondSurnames(String secondSurnames) {
		this.secondSurnames = secondSurnames;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getAdderss() {
		return adderss;
	}

	public void setAdderss(String adderss) {
		this.adderss = adderss;
	}

	public String getHomeCity() {
		return homeCity;
	}

	public void setHomeCity(String homeCity) {
		this.homeCity = homeCity;
	}

	@Override
	public String toString() {
		return "Customer [document=" + document + ", firsName=" + firsName + ", secondNames=" + secondNames
				+ ", surnames=" + surnames + ", secondSurnames=" + secondSurnames + ", telephone=" + telephone
				+ ", adderss=" + adderss + ", homeCity=" + homeCity + "]";
	}

}
