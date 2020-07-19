package com.gobrightside.qa.pages.android;

import org.openqa.selenium.support.PageFactory;

import com.gobrightside.qa.pages.CardsPage;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class AndroidCardsPage implements CardsPage{
	
    public AndroidCardsPage(MobileDriver<MobileElement> driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    
    
    //@FindBy(id = )

	
	public boolean isDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}

	
	public void clickSavingsAccount() {
		// TODO Auto-generated method stub
		
	}

	
	public void clickProfile() {
		// TODO Auto-generated method stub
		
	}

	
	public void clickHomeButton() {
		// TODO Auto-generated method stub
		
	}



}
