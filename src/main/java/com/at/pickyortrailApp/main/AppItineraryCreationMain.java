package com.at.pickyortrailApp.main;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.at.BaseClass.BaseClass;
import com.at.Locators.ItineraryCreationLocators;

public class AppItineraryCreationMain extends BaseClass{
	
	ItineraryCreationLocators locators = new ItineraryCreationLocators();; 
	
	
	public void itineraryCreation() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		locators = new ItineraryCreationLocators();
		try {
		locators.clickAction(locators.getNext());
		locators.clickAction(locators.getNext());
		locators.clickAction(locators.getNext());
		}
		catch(Exception e){
			System.out.println("Unable to click the Next in the App");
		}
		try {
			   locators.clickAction(locators.getStartplanning());
				}
				catch(Exception e){
					System.out.println("Unable to click the Start Planning in the App");
				}
		
		try {
			   locators.clickAction(locators.getCountry());
				}
				catch(Exception e){
					System.out.println("Unable to Select the country in the App");
				}
		
		try {
			   locators.clickAction(locators.getMonth());
				}
				catch(Exception e){
					System.out.println("Unable to Select the month in the App");
				}
		
		try {
			   locators.clickAction(locators.getDate());
				}
				catch(Exception e){
					System.out.println("Unable to Select the date in the App");
				}
		
		try {
			   locators.clickAction(locators.getFlight());
				}
				catch(Exception e){
					System.out.println("Unable to Select the flight in the App");
				}
		
		try {
			   locators.clickAction(locators.getDuration());
				}
				catch(Exception e){
					System.out.println("Unable to Select the duration in the App");
				}
		
		try {
			   locators.clickAction(locators.getPassengerCount());
				}
				catch(Exception e){
					System.out.println("Unable to Select the Passenger Count in the App");
				}
		
		try {
			   locators.clickAction(locators.getCity());
				}
				catch(Exception e){
					System.out.println("Unable to Select the city in the App");
				}
		
		try {
			   locators.clickAction(locators.getBuildItinerary());
				}
				catch(Exception e){
					
					System.out.println("Unable to click the Build itinerary in the App");
				}
		
		try {
				   locators.getMobile().sendKeys("9176089970");
					}
					catch(Exception e){
						System.out.println("Unable to Enter the Mobile number in the App");
					}
			locators.clickAction(locators.getConti());
			
			try {
				locators.clickAction(locators.getName());
				locators.getName().sendKeys("Lee");
					}
					catch(Exception e){
						System.out.println("Unable to Enter the Name in the App");
					}
			locators.clickAction(locators.getConti());
			
			
			try {
				   locators.clickAction(locators.getLanguage());
					}
					catch(Exception e){
						System.out.println("Unable to Select the Language in the App");
					}
			
			try {
				locators.clickAction(locators.getOtp());
				locators.getOtp().sendKeys("666666");
					}
					catch(Exception e){
						System.out.println("Unable to Enter the OTP in the App");
					}
			locators.clickAction(locators.getConti());
			
			
			try {
				   locators.clickAction(locators.getLoginCTA());
					}
					catch(Exception e){
						System.out.println("Unable to Click the Login CTA in the App");
					}
			
			WebElement validate = driver.findElement(By.xpath("//android.widget.TextView[@text='Proceed to book']"));
			if (validate.isDisplayed()) {
				Assert.assertTrue(true);
				System.out.println("Login Successfull! and Itinerary Created successfully!");
			} else {
				Assert.assertTrue(false);
				System.out.println("Login Successfull! and Itinerary creation failed!!");
			}

			Thread.sleep(5000);
			
			
		
		
		
	}
	
		
	

}
