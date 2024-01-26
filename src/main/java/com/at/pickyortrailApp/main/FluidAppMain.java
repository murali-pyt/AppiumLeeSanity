package com.at.pickyortrailApp.main;

import java.time.Duration;

import org.testng.Assert;

import com.at.BaseClass.BaseClassFluid;
import com.at.Locators.FluidAppLocators;

import io.appium.java_client.android.Activity;

public class FluidAppMain extends BaseClassFluid {

	FluidAppLocators locators = new FluidAppLocators();

//String gmailAppPackageName="com.google.android.gm";  //com.google.android.gm
//String gmailAppActivityName="com.google.android.gm.MainMailActivity";   //com.google.android.gm.MainMailActivity

	public void FluidApp() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		System.out.println("1. Fluid App opened Successfully!");
		locators = new FluidAppLocators();

		locators.clickAction(locators.getNext());
		locators.clickAction(locators.getNext());
		locators.clickAction(locators.getNext());

//	driver.startActivity(new Activity(gmailAppPackageName, gmailAppActivityName));
	}

	public void ClickingError() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		if (locators.getHomepage().isDisplayed()) {
			locators.clickAction(locators.getLogin());
			String acterror = locators.getError().getText();
			Thread.sleep(3000);
			String experror = "Please enter email and password to login";
			Assert.assertEquals(experror, acterror);
			System.out.println("2. Without  Entering the Email and Password error message validated successfully!");
		} else {
			System.out.println("Homepage is not displayed");
		}
	}

	public void wrongPasswordError() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		if (locators.getHomepage().isDisplayed()) {
			locators.clickAction(locators.getEmail());
			locators.sendKeys(locators.getEmailenter(), "rose@pytsandbox.com");
			locators.clickAction(locators.getPassword());
			locators.sendKeys(locators.getPasswordenter(), "corptravel");

			locators.clickAction(locators.getLogin());
			String actinvalid = locators.getIncorrectunpwd().getText();
			Thread.sleep(3000);
			String expinvalid = "Uh oh! Email ID & password combination is wrong";
			Assert.assertEquals(actinvalid, expinvalid);
			System.out.println("3. Entered the wrong Password and the error message validated successfully! ");
		} else {
			System.out.println("Homepage is not displayed");
		}

	}

	public void login() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// Thread.sleep(5000);
		locators.clickAction(locators.getEmail());
		locators.getEmailenter().clear();
		// Thread.sleep(2000);
		// locators.getEmail().sendKeys("rose@pytsandbox.com");

		locators.sendKeys(locators.getEmailenter(), "rose@pytsandbox.com");
		locators.clickAction(locators.getPassword());
		locators.getPasswordenter().clear();
		// Thread.sleep(2000);
		// locators.getPassword().sendKeys("corptravelisfun");
		locators.sendKeys(locators.getPasswordenter(), "corptravelisfun");
		locators.clickAction(locators.getLogin());

		Thread.sleep(8000);
		System.out.println("4. Logged in successfully");

		// locators.clickJavascriptElement(locators.getMyProfile());
	}

	public void Logout() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		locators.clickAction(locators.getMyProfile());

		locators.clickAction(locators.getLogout());

		if (locators.getConfirmLogout().isDisplayed()) {
			locators.clickAction(locators.getConfirmLogout());
			System.out.println("5. Confirmation for Logout Validated Successfully!");
		} else {
			System.out.println("Confirmation popup for Logout is not displayed");
		}

		if (locators.getHomepage().isDisplayed()) {
			Assert.assertTrue(true);
			System.out.println("6. Logged out Successfully!");
		} else {
			Assert.assertTrue(false);
			System.out.println("Error in Loggedout!");
		}

	}

	// Open Settings App
	// driver.startActivity(new Activity(settingsAppPackageName,
	// settingsAppActivityName));

}
