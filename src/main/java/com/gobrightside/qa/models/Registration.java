package com.gobrightside.qa.models;


public class Registration {

	private String firstName;
	private String lastName;
	private String ssn;
	private String email;


	public Registration(String firstName, String lastName, String ssn, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.ssn = ssn;
		this.email = email;
	}


	/**
	 * Gets the first name
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}


	/**
	 * Gets the last name
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}


	/**
	 * Gets the last 4 digits of ssn
	 * @return the ssn
	 */
	public String getSsn() {
		return ssn;
	}


	/**
	 * Gets the email
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	
}
