package com.gobrightside.qa.pages.android;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.gobrightside.qa.pages.LoginPage;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;




public class AndroidLoginPage implements LoginPage {
	
	// Constructor
	public AndroidLoginPage(MobileDriver<MobileElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	
	@FindBy(name = "username")
	WebElement username;



	// This method is being overridden from an interface: LoginPage
	public void clickLogin() {
		System.out.println("Clicking Login. This method is overridden from LoginPage and called in Android login page.");
		
	}
	
	
	
	
	//All other page related methods go here
	

}
