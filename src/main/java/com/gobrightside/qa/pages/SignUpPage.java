package com.gobrightside.qa.pages;


public interface SignUpPage {
	
	/**
	 * Verify "Sign Up" text is present on the page
	 * @return
	 */
	public String verifySignUpText();
	
	/**
	 * Sets the first name value.
	 * @param fname
	 */
	public void setFirstName(String fname);
	
	/**
	 * Sets the last name value.
	 * @param lName
	 */
	public void setLastName(String lname);
	
	/**
	 * Sets the last 4 digits of ssn
	 * @param ssn
	 */
	public void setLastFourDigitSSN(String sn);
	
	/**
	 * Sets the personal email
	 * @param email
	 */
	public void setPersonalEmail(String email);
	
	/**
	 * Clicks the continue button on 
	 */
	public void clickContinue();
	
	/**
	 * 
	 * @param txt
	 * @return
	 */
	public boolean isDisplayed(String txt);
	
	/**
	 * Validate first name field error message
	 * @return
	 */
	public boolean isFirstNameErrorVisible();
	
	/**
	 * @param <T>
	 * 
	 */
	public void setRegistrationInfo(String fname, String lname, String ssn, String email);


	
	
}
