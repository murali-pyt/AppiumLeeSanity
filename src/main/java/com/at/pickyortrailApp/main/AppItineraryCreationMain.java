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
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		locators = new ItineraryCreationLocators();
		locators.clickAction(locators.getNext());
		locators.clickAction(locators.getNext());
		locators.clickAction(locators.getNext());
			   locators.clickAction(locators.getStartplanning());
			   locators.clickAction(locators.getCountry());
				
			   locators.clickAction(locators.getMonth());
				
			   locators.clickAction(locators.getDate());
				
			   locators.clickAction(locators.getFlight());
				
			   locators.clickAction(locators.getDuration());
				
			   locators.clickAction(locators.getPassengerCount());
				
			   locators.clickAction(locators.getCity());
				
		
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
