package com.at.BaseClass;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.appium.java_client.android.AndroidDriver;

public class BaseClass {
	
	public static AndroidDriver driver;
	public static ThreadLocal<AndroidDriver> tdriver = new ThreadLocal<AndroidDriver>();
	
	
	
	public AndroidDriver initialization() {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("deviceName", "Android Emulator");
		cap.setCapability("udid", "emulator-5554");   //b9f8f075
		cap.setCapability("platformName", "Android");
		cap.setCapability("app", "/Users/pyt/Appium/PickyourtrailApp.apk");   ///Users/pyt/Appium/Fluid.apk
		cap.setCapability("appWaitActivity", "com.pickyourtrail.MainActivity");   //com.fluid.travel.MainActivity
	//	cap.setCapability("appWaitDuration", "60000");
	//	cap.setCapability("deviceReadyTimeout", "30");
		
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
