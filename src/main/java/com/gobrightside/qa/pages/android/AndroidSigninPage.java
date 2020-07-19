package com.gobrightside.qa.pages.android;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.gobrightside.qa.pages.SigninPage;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class AndroidSigninPage implements SigninPage{
	
	
    public AndroidSigninPage(MobileDriver<MobileElement> driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
	
    
    public static final String APP_PREFIX = "com.androidapp.gobrightside.mobile.debug:id/";
    
    
    //	phone number edit box
    @FindBy(id = APP_PREFIX + "phone")
    private MobileElement editPhoneNumber;
    
    //	phone number edit box
    @FindBy(id = APP_PREFIX + "nextButton")
    private MobileElement btnSignin;    

	/**
	 * Enter phone number on signin page
	 */
	@Override
	public void setPhoneNumber(String number) {
		editPhoneNumber.sendKeys(number);
	}

	/**
	 * Click signin button
	 */
	@Override
	public void clickSignin() {
		btnSignin.click();
	}

}
