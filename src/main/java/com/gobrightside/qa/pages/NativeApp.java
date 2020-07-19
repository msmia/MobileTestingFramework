package com.gobrightside.qa.pages;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;

/**
 * This interface will have the getters for all the pages. As
 * a parameter we'll pass in (MobileDriver<MobileElement> driver). So when a particular getter is called,
 * the object of that interface will be returned and return type will be that interface.
 * 
 * @author sharif.mia
 *
 */

public interface NativeApp {

	public HomePage getHomePage(MobileDriver<MobileElement> driver);

	public SignUpPage getSignUpPage(MobileDriver<MobileElement> driver);

	public DateOfBirthSignupPage getDateOfBirthSignupPage(MobileDriver<MobileElement> driver);

	public LoginPage getLoginPage(MobileDriver<MobileElement> driver);
	
	public SigninPage getSigninPage(MobileDriver<MobileElement> driver);
	
	public CodeConfirmationPage getConfirmationPage(MobileDriver<MobileElement> driver);

	public CardsPage getCardsPage(MobileDriver<MobileElement> driver);

}
