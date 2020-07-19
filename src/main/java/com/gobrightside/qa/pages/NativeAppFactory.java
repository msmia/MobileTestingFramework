package com.gobrightside.qa.pages;


import com.gobrightside.qa.pages.android.AndroidNativeApp;
import com.gobrightside.qa.testbase.TestBase;


/**
 * This class will return both IOS and Android Objects 
 * Platform property value will determine which platform to return.
 * @author sharif.mia
 *
 */


public class NativeAppFactory {
	
	public static NativeApp getNativeApp() {

		String platform = TestBase.prop.getProperty("platform");

		if (platform.equals("android"))
			return getAndroidNativeApp();
		else if (platform.equals("ios"))
			return getIOSNativeApp();
		else {
			throw new RuntimeException("Invalid Platform: " + platform);
		}
	}

	
	/**
	 * Return Android Native App
	 * @return
	 */
	private static NativeApp getAndroidNativeApp() {
		return new AndroidNativeApp();
	}
	
	
	/**
	 * Return IOS Native App
	 * @return
	 */
	private static NativeApp getIOSNativeApp() {
		return null;
	}
	

}


