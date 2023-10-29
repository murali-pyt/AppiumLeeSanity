package com.at.Locators;

import java.time.Duration;

import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.at.BaseClass.BaseClass;

import io.appium.java_client.android.AndroidDriver;

public class ItineraryCreationLocators extends BaseClass{
	
	public ItineraryCreationLocators() {
		PageFactory.initElements(driver, this); 

	}
	
	@FindBy(xpath = "//android.widget.TextView[@text = 'Next']")
	WebElement next;
	
	@FindBy(xpath = "//android.widget.ImageView")  
	WebElement startplanning;
	
	@FindBy(xpath = "//android.widget.TextView[@text = 'Europe']")  
	WebElement country;
	
	@FindBy(xpath = "//android.widget.TextView[@text = 'Feb']")  
	WebElement month;
	
	@FindBy(xpath = "//android.widget.TextView[@text = '30']")  
	WebElement date;
	
	@FindBy(xpath = "//android.widget.TextView[@text = 'Bengaluru, BLR']")  
	WebElement flight;
	
	@FindBy(xpath = "//android.widget.TextView[@text = '6-9 days']")  
	WebElement duration;
	
	@FindBy(xpath = "//android.widget.TextView[@text = 'Couple']")  
	WebElement passengerCount;
	
	@FindBy(xpath = "//android.widget.TextView[@text = 'Amsterdam']")  
	WebElement city;
	
	@FindBy(xpath = "//android.widget.TextView[@text = 'Done! Build Itinerary']")  
	WebElement buildItinerary;
	
	@FindBy(xpath = "//android.widget.EditText[@text = 'Mobile number']")  
	WebElement mobile;
	
	@FindBy(xpath = "//android.widget.TextView[@text = 'Continue']")  
	WebElement conti;
	
	@FindBy(xpath = "//android.widget.EditText[@text = 'Name']")  
	WebElement name;
	
	@FindBy(xpath = "//android.widget.TextView[@text = 'English']")  
	WebElement language;
	
	@FindBy(xpath = "//android.widget.EditText[@resource-id='textInput']")  
	WebElement otp;
	
	@FindBy(xpath = "//android.widget.TextView[@text = 'Verify']")  
	WebElement LoginCTA;
	
	
	
	
	
	public WebElement getCountry() {
		return country;
	}

	public void setCountry(WebElement country) {
		this.country = country;
	}

	public WebElement getMonth() {
		return month;
	}

	public void setMonth(WebElement month) {
		this.month = month;
	}

	public WebElement getDate() {
		return date;
	}

	public void setDate(WebElement date) {
		this.date = date;
	}

	public WebElement getFlight() {
		return flight;
	}

	public void setFlight(WebElement flight) {
		this.flight = flight;
	}

	public WebElement getDuration() {
		return duration;
	}

	public void setDuration(WebElement duration) {
		this.duration = duration;
	}

	public WebElement getPassengerCount() {
		return passengerCount;
	}

	public void setPassengerCount(WebElement passengerCount) {
		this.passengerCount = passengerCount;
	}

	public WebElement getCity() {
		return city;
	}

	public void setCity(WebElement city) {
		this.city = city;
	}

	public WebElement getBuildItinerary() {
		return buildItinerary;
	}

	public void setBuildItinerary(WebElement buildItinerary) {
		this.buildItinerary = buildItinerary;
	}

	public WebElement getMobile() {
		return mobile;
	}

	public void setMobile(WebElement mobile) {
		this.mobile = mobile;
	}

	public WebElement getConti() {
		return conti;
	}

	public void setConti(WebElement conti) {
		this.conti = conti;
	}

	public WebElement getName() {
		return name;
	}

	public void setName(WebElement name) {
		this.name = name;
	}

	public WebElement getLanguage() {
		return language;
	}

	public void setLanguage(WebElement language) {
		this.language = language;
	}

	public WebElement getOtp() {
		return otp;
	}

	public void setOtp(WebElement otp) {
		this.otp = otp;
	}

	public WebElement getLoginCTA() {
		return LoginCTA;
	}

	public void setLoginCTA(WebElement loginCTA) {
		LoginCTA = loginCTA;
	}

	public WebElement getNext() {
		return next;
	}

	public void setNext(WebElement next) {
		this.next = next;
	}

	public WebElement getStartplanning() {
		return startplanning;
	}

	public void setStartplanning(WebElement startplanning) {
		this.startplanning = startplanning;
	}

	public void clickAction(WebElement element) throws InterruptedException {
		try {
			pollingWait(element, 30);
			element.click();
		} catch (ElementNotInteractableException ex) {
			Thread.sleep(3000);
			clickAction(element);
		} catch (Exception ex) { //
			//Reports.reportStep("Failed to click the Webelement " + element, "FAIL");
			System.out.println("Failed to click the Webelement " + element);
			ex.printStackTrace();
		}
	}

	public void pollingWait(WebElement element, int timeOut) {

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(timeOut))
				.pollingEvery(Duration.ofSeconds(2)).ignoring(NoSuchElementException.class)
				.ignoring(StaleElementReferenceException.class);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		wait.until(ExpectedConditions.visibilityOf(element));

	}

	public void clickJavascriptElement(WebElement element) throws InterruptedException {
		try {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click()", element); //
			System.out.println("Successfully clicked the Javascript Webelement");
		} catch (ElementNotInteractableException ex) {
			Thread.sleep(3000);
			System.out.println("Unable to click for the first time and trying one more time");
			element.click();
		} catch (Exception ex) {
			System.out.println("Failed to click the Javascript Webelement");
		}
	}

	
//	public void implicitwait(AndroidDriver driver) {
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
//	}
	
	
	
	
	
	

}
