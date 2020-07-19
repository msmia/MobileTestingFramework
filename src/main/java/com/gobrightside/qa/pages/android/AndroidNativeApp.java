package com.gobrightside.qa.pages.android;

import com.gobrightside.qa.pages.CardsPage;
import com.gobrightside.qa.pages.CodeConfirmationPage;
import com.gobrightside.qa.pages.DateOfBirthSignupPage;
import com.gobrightside.qa.pages.HomePage;
import com.gobrightside.qa.pages.LoginPage;
import com.gobrightside.qa.pages.NativeApp;
import com.gobrightside.qa.pages.SignUpPage;
import com.gobrightside.qa.pages.SigninPage;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;




/**
 * 
 * This class "AndroidNativeApp" implements "NativeApp" interface 
 * and instantiates the classes in here and returns the object.
 * @author sharif.mia
 *
 */


public class AndroidNativeApp implements NativeApp {

	
	public SignUpPage getSignUpPage(MobileDriver<MobileElement> driver) {
		return new AndroidSignUpPage(driver);
	}

	
	public HomePage getHomePage(MobileDriver<MobileElement> driver) {
		return new AndroidHomePage(driver);
	}

	
	public LoginPage getLoginPage(MobileDriver<MobileElement> driver) {
		return new AndroidLoginPage(driver);
	}

	
	public DateOfBirthSignupPage getDateOfBirthSignupPage(MobileDriver<MobileElement> driver) {
		return new AndroidDateOfBirthPage(driver);
	}


	public SigninPage getSigninPage(MobileDriver<MobileElement> driver) {
		return new AndroidSigninPage(driver);
	}


	public CodeConfirmationPage getConfirmationPage(MobileDriver<MobileElement> driver) {
		return new AndroidCodeConfirmationPage(driver);
	}


	public CardsPage getCardsPage(MobileDriver<MobileElement> driver) {
		return new AndroidCardsPage(driver);
	}

}
