package com.gobrightside.qa.pages;


public interface DateOfBirthSignupPage {
	
	
	/**
	 * Verify "Verify Birthday" text is present on the page
	 * @return
	 */
	public String getBirthdayText();


	/**
	 * Click date of birth edit box
	 */
	public void clickDateOfBirthField();
	
	/**
	 * Click OK on the date widget
	 */
	public void clickOk();
	
	/**
	 * Click Continue button on verify birthday page
	 */
	public void clickContinue();
	
	/**
	 * Click Quit on Warning
	 */
	public void clickQuit();
	
	
    /**
     * Verify if the Error alert title is present
     */
	public boolean verifyAlertTitle();
	
}
