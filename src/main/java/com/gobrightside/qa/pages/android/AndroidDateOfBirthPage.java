package com.gobrightside.qa.pages.android;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.gobrightside.qa.pages.AbstractPage;
import com.gobrightside.qa.pages.DateOfBirthSignupPage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;



public class AndroidDateOfBirthPage extends AbstractPage implements DateOfBirthSignupPage {
	
	
	/**
	 * Constructor
	 * @param driver
	 */
    public AndroidDateOfBirthPage(MobileDriver<MobileElement> driver) {
    	super(driver);
    	PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
	
    
    public static final String APP_PREFIX = "com.androidapp.gobrightside.mobile.debug:id/";
	
    
    
    /**
     * Repositories go below
     */
    
    //	Verify Birthday
    @FindBy(id = APP_PREFIX + "titleText")
    private MobileElement txtTitle;	
    
    //	date of birth field
    @FindBy(id = APP_PREFIX + "dob")
    private MobileElement dob; 
    
    //	Ok Button
    @FindBy(id = "android:id/button1")
    private MobileElement btnOk;   
    
    //	Continue Button on  date of birth page
    @FindBy(id = APP_PREFIX + "nextButton")
    private MobileElement btnContinue;

    //	Click Quit Button on Alert
    @FindBy(id = "android:id/button2")
    private MobileElement btnQuit;
    
    // Date of Birth text on the datepicker widget
    @FindBy(id = "android:id/numberpicker_input")
    private MobileElement editBoxes;
    
    // Alert title
    @FindBy(id = "com.androidapp.gobrightside.mobile.debug:id/alertTitle")
    private MobileElement alertTitle;
    

    /**
     * Methods go below here
     */
    
    
    
    /**
     * Get Date of birth text
     */
	public String getBirthdayText() {
		String strText = txtTitle.getText();
		return strText;
	}

	/**
	 * Click date of birth field
	 */
	public void clickDateOfBirthField() {
		dob.click();
	}

	
	/**
	 * Click OK button on the widget
	 */
	public void clickOk() {
		btnOk.click();
	}

	
	/**
	 * Click Continue button on the birthday page
	 */
	public void clickContinue() {
		btnContinue.click();
	}
	
	/**
	 * Click Quit Button on Alert
	 */
	public void clickQuit() {
		btnQuit.click();
	}
	
	public void verifyDatePickerWidget() {
		
	}
	
	

    /**
     * Verify if the continue button is present on the date of birth page
     */
    public void isPresent() {
    	if(btnContinue.isDisplayed() == true) {
    		System.out.println("Continue button is displayed on date of birth page.");
    	} else {
    		System.out.println("Continue button is NOT displayed on date of birth page.");
    	}
    }
    

    /**
     * Verify if the Error alert title is present
     */
	public boolean verifyAlertTitle() {
		boolean tf = false;
		if (alertTitle.isDisplayed() == true)
			tf = true;
		return tf;
	}
    
    
    

    
    




}
