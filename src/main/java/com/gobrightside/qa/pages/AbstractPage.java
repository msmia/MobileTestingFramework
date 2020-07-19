package com.gobrightside.qa.pages;

import org.openqa.selenium.By;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;

public abstract class AbstractPage {
	
	
	protected MobileDriver<MobileElement> driver;
	MobileElement element;
	
	/**
	 * Constructor
	 * @param driver
	 */
	public AbstractPage(MobileDriver<MobileElement> driver){
		this.driver = driver;
	}
	
	/**
	 * Verify if an element is present on the page.
	 * 
	 * @param by
	 * @return boolean
	 */
	public boolean isElementPresent(By by) {

		boolean isElementPresent;

		try {
			element = driver.findElement(by);
			isElementPresent = true;
		} catch (Exception e) {
			isElementPresent = false;
		}
		return isElementPresent;
	}

	/**
	 * Verify if an element is selected on the page.
	 * 
	 * @param by
	 * @return boolean
	 */
	public boolean isElementSelected(By by) {

		boolean isElementSelected;

		try {
			element = driver.findElement(by);
			isElementSelected = true;
		} catch (Exception e) {
			isElementSelected = false;
		}
		return isElementSelected;
	}
	
	public boolean scrollIntoView(By by) {
		
		
		return false;
	}
	
	
	
}
