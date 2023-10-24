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

import com.at.BaseClass.BaseClassFluid;

public class FluidAppLocators extends BaseClassFluid{
	
	public FluidAppLocators() {
		PageFactory.initElements(driver, this); 

	}
	
	@FindBy(xpath = "//android.widget.TextView[@text = 'Next']")
	WebElement next;
	
	@FindBy(xpath = "//android.widget.TextView[@text = 'Work email']")
	WebElement email;
	
	@FindBy(xpath = "//android.widget.TextView[@text = 'Password']")
	WebElement password;
	
	@FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Login\"]")
	WebElement login;
	
	@FindBy(xpath = "(//android.widget.ImageView)[2]")  
	WebElement myProfile;
	
	@FindBy(xpath = "//android.widget.TextView[@text = 'Logout']")
	WebElement logout;
	
	@FindBy(xpath = "//android.widget.TextView[@text = 'Yes, logout']")
	WebElement confirmLogout;
	
	@FindBy(xpath = "//android.widget.TextView[@text = 'Sign in to Fluid!']")
	WebElement homepage;
	
	@FindBy(xpath = "//android.widget.EditText")
	WebElement emailenter;
	
	@FindBy(xpath = "(//android.widget.EditText)[2]")
	WebElement passwordenter;
	
	@FindBy(xpath = "//android.widget.TextView[@text = 'Please enter email and password to login']")
	WebElement error;
	
	@FindBy(xpath = "//android.widget.TextView[@text = 'Uh oh! Email ID & password combination is wrong']")
	WebElement incorrectunpwd;
	
	
	

	public WebElement getError() {
		return error;
	}

	public void setError(WebElement error) {
		this.error = error;
	}

	public WebElement getIncorrectunpwd() {
		return incorrectunpwd;
	}

	public void setIncorrectunpwd(WebElement incorrectunpwd) {
		this.incorrectunpwd = incorrectunpwd;
	}


	public WebElement getPasswordenter() {
		return passwordenter;
	}

	public void setPasswordenter(WebElement passwordenter) {
		this.passwordenter = passwordenter;
	}

	public WebElement getEmail() {
		return email;
	}

	public WebElement getEmailenter() {
		return emailenter;
	}

	public void setEmailenter(WebElement emailenter) {
		this.emailenter = emailenter;
	}

	public void setEmail(WebElement email) {
		this.email = email;
	}

	public WebElement getPassword() {
		return password;
	}

	public void setPassword(WebElement password) {
		this.password = password;
	}

	public WebElement getLogin() {
		return login;
	}

	public void setLogin(WebElement login) {
		this.login = login;
	}

	public WebElement getMyProfile() {
		return myProfile;
	}

	public void setMyProfile(WebElement myProfile) {
		this.myProfile = myProfile;
	}

	public WebElement getLogout() {
		return logout;
	}

	public void setLogout(WebElement logout) {
		this.logout = logout;
	}

	public WebElement getConfirmLogout() {
		return confirmLogout;
	}

	public void setConfirmLogout(WebElement confirmLogout) {
		this.confirmLogout = confirmLogout;
	}

	public WebElement getHomepage() {
		return homepage;
	}

	public void setHomepage(WebElement homepage) {
		this.homepage = homepage;
	}

	public WebElement getNext() {
		return next;
	}

	public void setNext(WebElement next) {
		this.next = next;
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
	
	public void sendKeys(WebElement a, String data) {
		a.sendKeys(data);
	}


}
