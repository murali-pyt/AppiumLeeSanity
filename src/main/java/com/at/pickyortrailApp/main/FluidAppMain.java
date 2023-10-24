package com.at.pickyortrailApp.main;

import java.time.Duration;

import org.testng.Assert;

import com.at.BaseClass.BaseClassFluid;
import com.at.Locators.FluidAppLocators;

public class FluidAppMain extends BaseClassFluid{
	
FluidAppLocators locators = new FluidAppLocators(); 
	
	
	public void FluidApp() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		locators = new FluidAppLocators();
		
		locators.clickAction(locators.getNext());
		locators.clickAction(locators.getNext());
		locators.clickAction(locators.getNext());
		
		
		
		if(locators.getHomepage().isDisplayed())
		{
			locators.clickAction(locators.getLogin());
			String acterror = locators.getError().getText();
			Thread.sleep(3000);
			String experror = "Please enter email and password to login";
			Assert.assertEquals(experror, acterror);
		}else {
			System.out.println("Homepage is not displayed");
		}
		
		

		if(locators.getHomepage().isDisplayed())
		{
			locators.clickAction(locators.getEmail());
			locators.sendKeys(locators.getEmailenter(), "rose@pytsandbox.com");
			locators.clickAction(locators.getPassword());
			locators.sendKeys(locators.getPasswordenter(), "corptravel");
			
			
			locators.clickAction(locators.getLogin());
			String actinvalid = locators.getIncorrectunpwd().getText();
			Thread.sleep(3000);
			String expinvalid = "Uh oh! Email ID & password combination is wrong";
			Assert.assertEquals(actinvalid, expinvalid);
		}else {
			System.out.println("Homepage is not displayed");
		}
		
		
		
		
		
		
	//	Thread.sleep(5000);
		locators.clickAction(locators.getEmail());
		locators.getEmailenter().clear();
	//	Thread.sleep(2000);
	//	locators.getEmail().sendKeys("rose@pytsandbox.com");
		
		locators.sendKeys(locators.getEmailenter(), "rose@pytsandbox.com");
		locators.clickAction(locators.getPassword());
		locators.getPasswordenter().clear();
	//	Thread.sleep(2000);
	//	locators.getPassword().sendKeys("corptravelisfun");
		locators.sendKeys(locators.getPasswordenter(), "corptravelisfun");
		locators.clickAction(locators.getLogin());
		
		Thread.sleep(5000);
		
	//	locators.clickJavascriptElement(locators.getMyProfile());
		
		
		locators.clickAction(locators.getMyProfile());
		
		locators.clickAction(locators.getLogout());
		locators.clickAction(locators.getConfirmLogout());
		
		if (locators.getHomepage().isDisplayed()) {
			Assert.assertTrue(true);
			System.out.println("Logged in && Logged out Successfull!");
		} else {
			Assert.assertTrue(false);
			System.out.println("Error in Loggedout!");
		}
		

}
}