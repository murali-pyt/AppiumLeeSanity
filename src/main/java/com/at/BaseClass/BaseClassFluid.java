package com.at.BaseClass;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;

public class BaseClassFluid {
	
	public static AndroidDriver driver;
	public static ThreadLocal<AndroidDriver> tdriver = new ThreadLocal<AndroidDriver>();
	
//	public static String settingsAppPackageName="com.android.settings";
//	public static String settingsAppActivityName="com.android.settings.Settings";
		
	
	public AndroidDriver initialization() {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("deviceName", "Android Emulator");
		cap.setCapability("udid", "emulator-5554");   
		cap.setCapability("platformName", "Android");
		cap.setCapability("app", "/Users/pyt/Appium/Fluid.apk");   
		cap.setCapability("appWaitActivity", "com.fluid.travel.MainActivity");   
		cap.setCapability("noReset", true);
//		cap.setCapability("appWaitDuration", "60000");
//		cap.setCapability("deviceReadyTimeout", "30");
//		
		try {
			driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), cap);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
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
