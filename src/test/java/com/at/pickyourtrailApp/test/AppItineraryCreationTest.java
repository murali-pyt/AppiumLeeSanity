package com.at.pickyourtrailApp.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.at.BaseClass.BaseClass;
import com.at.pickyortrailApp.main.AppItineraryCreationMain;
import com.at.pickyortrailApp.main.ItineraryPageMain;

public class AppItineraryCreationTest extends BaseClass{
	
AppItineraryCreationMain main;

	
	@BeforeMethod
	public void launchApp() {
		initialization();
		main = new AppItineraryCreationMain();
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
