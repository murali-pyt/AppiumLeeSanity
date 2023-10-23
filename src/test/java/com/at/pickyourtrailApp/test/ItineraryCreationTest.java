package com.at.pickyourtrailApp.test;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.at.pickyortrailApp.main.Baseclass;
import com.at.pickyortrailApp.main.ItineraryPageMain;
import com.qa.allurelistener.TestAllureListener;
import io.appium.java_client.android.AndroidDriver;

@Listeners({ TestAllureListener.class })
public class ItineraryCreationTest extends Baseclass{
//	public static AndroidDriver driver;
	ItineraryPageMain main;

	
	@BeforeMethod
	public void launchApp() {
		initialization();
		main = new ItineraryPageMain();
	}

	@Test(priority = 0)
	public void itineraryCreationTest() throws InterruptedException {
		main.itineraryCreation();
	}

	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}
