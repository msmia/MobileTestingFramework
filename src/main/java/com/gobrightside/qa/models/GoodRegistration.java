package com.gobrightside.qa.models;

public class GoodRegistration {
	
	String firstName;
	String lastName;
	String ssn;
	String email;
	String birthDay;
	String mailingAddress1;
	String mailingCity;
	String mailingState;
	String mailingZip;
	String phone;
	
	/**
	 * @param firstName
	 * @param lastName
	 * @param ssn
	 * @param email
	 * @param birthDay
	 * @param mailingAddress1
	 * @param mailingCity
	 * @param mailingState
	 * @param mailingZip
	 * @param phone
	 */
	
/*	
	public GoodRegistration(String firstName, String lastName, String ssn, String email, String birthDay,
			String mailingAddress1, String mailingCity, String mailingState, String mailingZip, String phone) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.ssn = ssn;
		this.email = email;
		this.birthDay = birthDay;
		this.mailingAddress1 = mailingAddress1;
		this.mailingCity = mailingCity;
		this.mailingState = mailingState;
		this.mailingZip = mailingZip;
		this.phone = phone;
	}
	
*/
	
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @return the ssn
	 */
	public String getSsn() {
		return ssn;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @return the birthDay
	 */
	public String getBirthDay() {
		return birthDay;
	}
	/**
	 * @return the mailingAddress1
	 */
	public String getMailingAddress1() {
		return mailingAddress1;
	}
	/**
	 * @return the mailingCity
	 */
	public String getMailingCity() {
		return mailingCity;
	}
	/**
	 * @return the mailingState
	 */
	public String getMailingState() {
		return mailingState;
	}
	/**
	 * @return the mailingZip
	 */
	public String getMailingZip() {
		return mailingZip;
	}
	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}
	
	
	public String demo() {
		return "This is a string";
	}
	

}
