package com.gobrightside.qa.models.testDataTypes;

public class Address {

	
	private String mailingAddress1;
	private String mailingCity;
	private String mailingState;
	private String mailingZip;
	

	/**
	 * @param mailingAddress1
	 * @param mailingCity
	 * @param mailingState
	 * @param mailingZip
	 */
	public Address(String mailingAddress1, String mailingCity, String mailingState, String mailingZip) {
		super();
		this.mailingAddress1 = mailingAddress1;
		this.mailingCity = mailingCity;
		this.mailingState = mailingState;
		this.mailingZip = mailingZip;
	}
	
	
	/**
	 * @return the mailingAddress1
	 */
	public String getMailingAddress1() {
		return mailingAddress1;
	}
	/**
	 * @param mailingAddress1 the mailingAddress1 to set
	 */
	public void setMailingAddress1(String mailingAddress1) {
		this.mailingAddress1 = mailingAddress1;
	}
	/**
	 * @return the mailingCity
	 */
	public String getMailingCity() {
		return mailingCity;
	}
	/**
	 * @param mailingCity the mailingCity to set
	 */
	public void setMailingCity(String mailingCity) {
		this.mailingCity = mailingCity;
	}
	/**
	 * @return the mailingState
	 */
	public String getMailingState() {
		return mailingState;
	}
	/**
	 * @param mailingState the mailingState to set
	 */
	public void setMailingState(String mailingState) {
		this.mailingState = mailingState;
	}
	/**
	 * @return the mailingZip
	 */
	public String getMailingZip() {
		return mailingZip;
	}
	/**
	 * @param mailingZip the mailingZip to set
	 */
	public void setMailingZip(String mailingZip) {
		this.mailingZip = mailingZip;
	}
	
	
	

}
