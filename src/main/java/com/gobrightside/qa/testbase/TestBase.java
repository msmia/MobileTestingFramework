package com.gobrightside.qa.testbase;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.gobrightside.qa.util.PropertyFileReader;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;

/**
 * This is the parent class. Every class will inherit from this class This class
 * will have webdrivers, android drivers, ios drivers. Depending on the driver
 * is called in the test, that particular test will run. Ex: IOS (IOS test will
 * run) There will be a properties file with the initial values which will be
 * needed for the initialization of the test All those static methods like
 * explicitWait on element can be written here as well. Check explicit wait
 * below.
 */
public class TestBase {

	static Logger log;
	public static Properties prop;
	public static File fs;

	public MobileDriver<MobileElement> driver;

	public static final String RESOURCES_PATH = "src/main/resources/";
	public static final String APPS_PATH = RESOURCES_PATH + "com/gobrightside/qa/apps";
	public static final String PROPERTIES_PATH = RESOURCES_PATH + "com/gobrightside/qa/properties/";
	public static final String DATA_PATH = RESOURCES_PATH + "com/gobrightside/qa/data/";
	public static final String UTIL_PATH = RESOURCES_PATH + "com/gobrightside/qa/util/";

	static {
		prop = PropertyFileReader.readPropertyFiles(PROPERTIES_PATH + "config.properties");
	}

	/**
	 * To initialize the AndroidDriver, IOS Driver, emulator, properties, etc
	 * 
	 * @throws IOException
	 */
	public void initialization() {

		String platform = prop.getProperty("platform");
		String serverNPort = prop.getProperty("serverNPort");

		try {

			if (platform.equals("android")) {

				fs = new File(APPS_PATH, "brightside-1.10.1-DEV (3).apk");

				DesiredCapabilities cap = new DesiredCapabilities();
				cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
				cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Nexus_5X_API_28");
				cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
				cap.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath());

				driver = new AndroidDriver<MobileElement>(new URL(serverNPort), cap);

			} else if (platform.equals("ios")) {

				fs = new File(APPS_PATH, "brightside-1.10.0-DEV (1).apk");

				DesiredCapabilities cap = new DesiredCapabilities();
				cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "IOS");
				cap.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 6s");
				cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);
				cap.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath());

				driver = new IOSDriver<MobileElement>(new URL(serverNPort), cap);

			}

			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		} catch (IOException | WebDriverException | NullPointerException e) {
			System.out.println("Custom message - TestBase: " + e.getMessage());
		}
	}
	
	
	
}
