package com.gobrightside.qa.pages.android;

import java.util.NoSuchElementException;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.gobrightside.qa.pages.AbstractPage;
import com.gobrightside.qa.pages.HomePage;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;


public class AndroidHomePage extends AbstractPage implements HomePage {
	

	public AndroidHomePage(MobileDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	
    public static final String APP_PREFIX = "com.androidapp.gobrightside.mobile.debug:id/";
	
    
    //	Object Sign Up Button
    @FindBy(id = APP_PREFIX + "createAccount")
    private MobileElement btnSignUp;
    
    
    //	Welcome Text on the home page
    @FindBy(id = APP_PREFIX + "title")
    private MobileElement txtTitle;	
    
    // Signin button
    @FindBy(id = APP_PREFIX + "signinLink")
    private MobileElement signinLink;

    
    
	/**
	 * Click SignUp Button on the gobrightside Home page
	 */
	@Override
	public void clickSignUp() {
		btnSignUp.click();
	}
	
	/**
	 * Click signin Link on the gobrightside Home page
	 */
	@Override
	public void clickSignin() {
		signinLink.click();
	}


	/**
	 * Verify if the sign up button is displayed
	 * @return
	 */
	public boolean isSignUpButtonPresent() {
		boolean isPresent = false;
		try {
			if (btnSignUp.isDisplayed() == true)
				isPresent = true;
		} catch (NoSuchElementException | TimeoutException e) {
			//System.out.println("Android Sign Up button wasn't found and it timed out.");
			e.getMessage();
		}
		return isPresent;
	}
}
