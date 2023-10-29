package com.at.pickyortrailApp.main;


import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class Baseclass {
	
	public static AndroidDriver driver;
	public static ThreadLocal<AndroidDriver> tdriver = new ThreadLocal<AndroidDriver>();
	
	public AndroidDriver initialization() {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("deviceName", "Android Emulator");
		cap.setCapability("udid", "emulator-5554");   //b9f8f075
		cap.setCapability("platformName", "Android");
		cap.setCapability("app", "/Users/pyt/Appium/PickyourtrailApp.apk");
		cap.setCapability("appActivity", "com.pickyourtrail.MainActivity");
//		cap.setCapability("platformVersion", "13");
//		cap.setCapability("appPackage", "com.pickyourtrail"); // com.pickyourtrail
//		cap.setCapability("appActivity", "com.pickyourtrail.MainActivity"); // com.pickyourtrail.MainActivity
//		cap.setCapability("noRest", "True");
//		cap.setCapability("shouldTerminateApp", true);
		
		try {
			driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), cap);
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
		tdriver.set(driver);
		return getDriver();
	}
	
	public static synchronized AndroidDriver getDriver() {
		return tdriver.get();
	}

}
