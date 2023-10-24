package com.at.pickyourtrailApp.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.at.BaseClass.BaseClassFluid;
import com.at.pickyortrailApp.main.FluidAppMain;

public class FluidAppTest extends BaseClassFluid{
	
FluidAppMain main;

	
	@BeforeMethod
	public void launchApp() {
		initialization();
		main = new FluidAppMain();
	}

	@Test(priority = 0)
	public void FluidAppTTest() throws InterruptedException {
		main.FluidApp();
	}

	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}
