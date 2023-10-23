package com.qa.allurelistener;



import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.at.pickyortrailApp.main.Baseclass;

import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Attachment;

public class TestAllureListener implements ITestListener {

	private static String getTestMethodName(ITestResult iTestResult) {
		return iTestResult.getMethod().getConstructorOrMethod().getName();
	}

	// Text attachments for Allure
	@Attachment(value = "Page screenshot", type = "image/png")
	public byte[] saveScreenshotPNG(AndroidDriver driver) {
		return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	}

	// Text attachments for Allure
	@Attachment(value = "{0}", type = "text/plain")
	public static String saveTextLog(String message) {
		return message;
	}

	// HTML attachments for Allure
	@Attachment(value = "{0}", type = "text/html")
	public static String attachHtml(String html) {
		return html;
	}

	public void onStart(ITestContext iTestContext) {
		System.out.println("I am in onStart method " + iTestContext.getName());
		iTestContext.setAttribute("AndroidDriver", Baseclass.getDriver());
	}

	public void onFinish(ITestContext iTestContext) {
		System.out.println("I am in onFinish method " + iTestContext.getName());
	}

	public void onTestStart(ITestResult iTestResult) {
		System.out.println("I am in onTestStart method " + getTestMethodName(iTestResult) + " start");
	}

	public void onTestSuccess(ITestResult iTestResult) {
		System.out.println("I am in onTestSuccess method " + getTestMethodName(iTestResult) + " succeed");
		AndroidDriver driver = Baseclass.getDriver();
		// Allure ScreenShotRobot and SaveTestLog
		if (driver instanceof AndroidDriver) {
			System.out.println("Screenshot captured for test case:" + getTestMethodName(iTestResult));
			saveScreenshotPNG(driver);
		}
		// Save a log on allure.
		saveTextLog(getTestMethodName(iTestResult) + " failed and screenshot taken!");
	}

	public void onTestFailure(ITestResult iTestResult) {
		System.out.println("I am in onTestFailure method " + getTestMethodName(iTestResult) + " failed");
	//	Object testClass = iTestResult.getInstance();
		AndroidDriver driver = Baseclass.getDriver();
		// Allure ScreenShotRobot and SaveTestLog
		if (driver instanceof AndroidDriver) {
			System.out.println("Screenshot captured for test case:" + getTestMethodName(iTestResult));
			saveScreenshotPNG(driver);
		}
		// Save a log on allure.
		saveTextLog(getTestMethodName(iTestResult) + " failed and screenshot taken!");
	}

	
	public void onTestSkipped(ITestResult iTestResult) {
		System.out.println("I am in onTestSkipped method " + getTestMethodName(iTestResult) + " skipped");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
		System.out.println("Test failed but it is in defined success ratio " + getTestMethodName(iTestResult));
	}

}

