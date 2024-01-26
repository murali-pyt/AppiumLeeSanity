package com.at.pickyourtrailApp.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.at.BaseClass.BaseClassFluid;
import com.at.pickyortrailApp.main.FluidAppMain;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;

public class FluidAppTest extends BaseClassFluid{
	
FluidAppMain main;

	
	@BeforeTest
	public void launchApp() {
		initialization();
		main = new FluidAppMain();
	}

	@Test(priority = 0)
	@Step("Opening the Fluid Mobile App")
	@Description("Verify App Launched or not")
	@Severity(SeverityLevel.CRITICAL)
	public void AppLaunch() throws InterruptedException {
		main.FluidApp();
	}
	
	@Test(priority = 1)
	@Step("Without  Entering the Email and Password clicking on Login")
	@Description("Verify Without  Entering the Email and Password clicking on Login is working or not")
	@Severity(SeverityLevel.CRITICAL)
	public void EmptyError() throws InterruptedException {
		main.ClickingError();
	}
	
	
	@Test(priority = 2)
	@Step("Opening the Fluid Mobile App")
	@Description("Verify App Launched or not")
	@Severity(SeverityLevel.CRITICAL)
	public void WrongCredentials() throws InterruptedException {
		main.wrongPasswordError();
	}
	
	@Test(priority = 3)
	public void Loggedin() throws InterruptedException {
		main.login();
	}
	
	@Test(priority = 4)
	public void Loggedout() throws InterruptedException {
		main.Logout();
	}

	
	@AfterTest
	public void teardown() {
		driver.quit();
	}

}
