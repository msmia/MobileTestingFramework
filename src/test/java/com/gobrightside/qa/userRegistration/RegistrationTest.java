package com.gobrightside.qa.userRegistration;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.NoSuchElementException;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.openqa.selenium.TimeoutException;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.gobrightside.qa.models.Registration;
import com.gobrightside.qa.models.TestUsers;
import com.gobrightside.qa.pages.CodeConfirmationPage;
import com.gobrightside.qa.pages.DateOfBirthSignupPage;
import com.gobrightside.qa.pages.HomePage;
import com.gobrightside.qa.pages.NativeApp;
import com.gobrightside.qa.pages.NativeAppFactory;
import com.gobrightside.qa.pages.SignUpPage;
import com.gobrightside.qa.pages.SigninPage;
import com.gobrightside.qa.testbase.TestBase;
import com.gobrightside.qa.util.Email;
import com.gobrightside.qa.util.JsonFileReader;
import com.gobrightside.qa.util.SqlConnection;


public class RegistrationTest extends TestBase {

	Email email;
	SignUpPage signupPage;
	SigninPage signinPage;
	CodeConfirmationPage codeConfirmationPage;
	DateOfBirthSignupPage dobPage;
	HomePage homePage;
	NativeApp nativeApp;
	SqlConnection sql;
	ResultSet rs;
	Logger log = Logger.getLogger("test-logger");
	

	public RegistrationTest() {super();}

	@BeforeMethod()
	public void setup() {
		initialization();
		email = new Email();
		nativeApp = NativeAppFactory.getNativeApp();
		log.setLevel(Level.ALL);
	}


	@Test(enabled = false)
	public void failedRegistratoinTest() {

		// Registration data.
		Registration badUser = JsonFileReader.loadDaTa(TestBase.DATA_PATH, "bad-client.json", Registration.class);

		try {
			navigateToSignupPage();
			enterRegistrationInfo(badUser);
			enterDateOfBirth(badUser);
		} catch (IllegalArgumentException | NullPointerException | NoSuchElementException | TimeoutException e) {
			String name = new Object() {
			}.getClass().getEnclosingMethod().getName(); // method name
			System.out.println("Custom Message: " + name + ": " + e.getMessage());
		}
	}


	@Test(enabled = false)
	public void goodRegistrationTest() {

		Registration goodUser = JsonFileReader.loadDaTa(RESOURCES_PATH, "good-client.json", Registration.class);
		try {
			navigateToSignupPage();
			enterRegistrationInfo(goodUser);
			enterDateOfBirth(goodUser);
		} catch (Exception e) {
			e.getMessage();
		}
	}


	@Test(enabled = false, invocationCount = 1)
	public void signinTest() {

		try {
			homePage = nativeApp.getHomePage(driver);
			log.debug("Home page object has been created.");
			homePage.clickSignin();
			log.debug("Signin button is clicked");
			signinPage = nativeApp.getSigninPage(driver);
			signinPage.setPhoneNumber("7746130884");
			signinPage.clickSignin();
			codeConfirmationPage = nativeApp.getConfirmationPage(driver);
			codeConfirmationPage.setConfirmationCode(email.readConfirmationCode());
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * If a user is not setup yet (no data found for the user in client_card, workflow, saving_account tables),
	 * get the information from json file and update the user's client_info table.
	 * @throws SQLException
	 */
	@Test(enabled = false)
	public void readUserData() throws SQLException {
		sql = new SqlConnection();
		String guid = null;
		TestUsers[] testUsers = JsonFileReader.loadDaTa(TestBase.DATA_PATH, "test-users-info.json", TestUsers[].class);
		for (int i = 0; i < testUsers.length; i++) {
			guid = testUsers[i].getGuid();
			if (guid.equals("a3052aca-f227-45ff-b415-983ed9aaccc2")) {
				sql.updateUserInfo(testUsers, i, guid);
			}
		}
	}
	
	/**
	 * This method will verify if the user is registered.
	 */
	@Test
	public void isUserRegistered() {
		// run jenkins job
		// run delete queries
		
		// delete client_card
		String guid = "45cff655-a34d-4dbf-b040-c359d2f7dd9b";
		sql = new SqlConnection();
		
		String clientCard = "delete from comcast.client_card where user_guid = " + guid;
		String clientWordflow = "delete from comcast.client_workflow where user_guid = " + guid;
		String clientTransfer = "delete from comcast.savings_transfer where savings_id in (select distinct savings_id from comcast.savings_account where user_guid = "+ guid +")";
		String clientSavingsAcct = "delete from comcast.savings_account where user_guid = " + guid;
		
		
		sql.deleteClient_card_savings_workflow(sql, rs, clientCard);
		//sql.deleteClient_card_savings_workflow(sql, rs, clientWordflow);
		//sql.deleteClient_card_savings_workflow(sql, rs, clientTransfer);
		//sql.deleteClient_card_savings_workflow(sql, rs, clientSavingsAcct);
		
	}
	
	
	/**
	 * Navigate to Sign Up Page
	 */
	private void navigateToSignupPage() {
		try {
			homePage = nativeApp.getHomePage(driver);
			Assert.assertEquals(homePage.isSignUpButtonPresent(), true, "The Sign Up button wasn't found.");
			homePage.clickSignUp();
		} catch (NoSuchElementException | TimeoutException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Enter Registration Information
	 */
	private void enterRegistrationInfo(Registration user) {
		signupPage = nativeApp.getSignUpPage(driver);
		signupPage.setFirstName(user.getFirstName());
		signupPage.setLastName(user.getLastName());
		signupPage.setLastFourDigitSSN(user.getSsn());
		signupPage.setPersonalEmail(user.getEmail());
		signupPage.clickContinue();
	}

	/**
	 * Enter date of birth information
	 */
	private void enterDateOfBirth(Registration user) {
		dobPage = nativeApp.getDateOfBirthSignupPage(driver);
		dobPage.clickDateOfBirthField();
		dobPage.clickOk();
		dobPage.clickContinue();
		Assert.assertEquals(dobPage.verifyAlertTitle(), true, "The alert massage on the date picker didn't appear.");
	}

	/**
	 * Tear down
	 */
	@AfterClass
	public void closeApp() {
		try {
			driver.closeApp();
		} catch (NullPointerException e) {
			System.out.println("Driver was failed to initialize. Therefore it couldn't be closed.");
		}
	}

}
