package com.gobrightside.qa.pages.android;



import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.gobrightside.qa.pages.SignUpPage;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;



public class AndroidSignUpPage implements SignUpPage {
	
    public AndroidSignUpPage(MobileDriver<MobileElement> driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
	
    
    public static final String APP_PREFIX = "com.androidapp.gobrightside.mobile.debug:id/";
	
    
    

     // Repositories go below

    
    //	VerifySignUp Page Appeared
    @FindBy(id = APP_PREFIX + "titleText")
    private MobileElement txtSignUp;
    
    //	Click Sign Up page
    @FindBy(id = APP_PREFIX + "createAccount")
    private MobileElement btnSignUp;	
	
    //	First Name
    @FindBy(id = APP_PREFIX + "firstName")
    private MobileElement fName;
    
    //	Last Name
    @FindBy(id = APP_PREFIX + "lastName")
    private MobileElement lName;
    
    //	SSN
    @FindBy(id = APP_PREFIX + "ssn")
    private MobileElement ssn;
    
    //	Personal Email
    @FindBy(id = APP_PREFIX + "email")
    private MobileElement pEmail;
    
    //	Continue Button on the sign up page
    @FindBy(id = APP_PREFIX + "nextButton")
    private MobileElement btnContinue;    
    
    //	Verify Birthday
    @FindBy(id = APP_PREFIX + "titleText")
    private MobileElement verifyBDay;	
    
    //	date of birth field
    @FindBy(id = APP_PREFIX + "dob")
    private MobileElement dob; 
    
    //	Ok Button
    @FindBy(id = "android:id/button1")
    private MobileElement btnOkOnDB;   
    
    //	Continue Button on  date of birth page
    @FindBy(id = APP_PREFIX + "nextButton")
    private MobileElement btnContinueOnDB; 
    
    
    
    
   

     // Methods go below
    
    
    

	public boolean isDisplayed( String txt) {
		boolean tf = false;
		if(verifyBDay.getText() == txt) {
			tf = true;
		} else {
			tf = false;
		} 
		return tf;
	}
    
	/**
	 * Sign Up Button
	 */
	public void clickSignUp() {
		btnSignUp.click();
	}
	
	/**
	 * Verify Sign Up page appeared 
	 */
	public String verifySignUpText() {
		return txtSignUp.getText();
	}

	/**
	 * Sets the First Name
	 */
	public void setFirstName(String fname) {
		fName.sendKeys(fname);
	}


	/**
	 * Sets the Last Name
	 */
	public void setLastName(String lname) {
		lName.sendKeys(lname);	
	}


	/**
	 * Sets the SSN
	 */
	public void setLastFourDigitSSN(String sn) {
		ssn.sendKeys(sn);
	}


	/**
	 * Sets the personal Email
	 */
	public void setPersonalEmail(String email) {
		pEmail.sendKeys(email);
	}


	/**
	 * Continue Button on Sign up page
	 */
	public void clickContinue() {
		btnContinue.click();
	}


	/**
	 * Verify first name field error message
	 */
	public boolean isFirstNameErrorVisible() {
		return false;
	}

	
	public void setRegistrationInfo(String fname, String lName, String sn, String email) {
		setFirstName(fname);
		setLastName(lName);
		setLastFourDigitSSN(sn);
		setPersonalEmail(email);
	}
}
