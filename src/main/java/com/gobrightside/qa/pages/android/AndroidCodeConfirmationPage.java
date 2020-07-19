package com.gobrightside.qa.pages.android;

import java.util.List;

import javax.management.RuntimeErrorException;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.gobrightside.qa.pages.CodeConfirmationPage;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class AndroidCodeConfirmationPage implements CodeConfirmationPage {

	public AndroidCodeConfirmationPage(MobileDriver<MobileElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	public static final String APP_PREFIX = "com.androidapp.gobrightside.mobile.debug:id/";

	// phone number edit box
	@FindBy(className = "android.widget.EditText")
	private List<MobileElement> codeFields;

	/**
	 * Get confirmation code fields. There should be six fields
	 */
	public int getConfirmationCodeFields() {
		return codeFields.size();
	}

	/**
	 * Set the confirmation code
	 */
	public void setConfirmationCode(String[] confirmationCode) {

		try {
			for (int i = 0; i < confirmationCode.length; i++) {
				codeFields.get(i).sendKeys(confirmationCode[i]);
			}
		} catch (RuntimeErrorException e) {
			System.out.println(e.getMessage());
			System.out.println("Most likely the confirmation code was wrong.");
		}
	}

	/**
	 * Click confirmation code
	 */
	public void clickConfirmCode() {
		// TODO Auto-generated method stub
	}

}
