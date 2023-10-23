package com.at.pickyortrailApp.main;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginCheck extends Baseclass{
	
	@FindBy(xpath = "//android.view.ViewGroup")
	WebElement accountIcon;

	
	
	
	
	public LoginCheck() {
		PageFactory.initElements(driver, this);
	}
	
	public void login() {
		
	}
	
}
