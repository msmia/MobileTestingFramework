package com.gobrightside.qa.pages;

public interface HomePage {
	
	public static final String WELCOME_TEXT = "Welcome to Brightside";
	
	public static final String SIGN_UP_BUTTON = "Sign Up";
	
	/**
	 * Verify if the sign up button is displayed
	 * @return
	 */
	public boolean isSignUpButtonPresent();
	
	public void clickSignUp();
	
	public void clickSignin();
	
}
