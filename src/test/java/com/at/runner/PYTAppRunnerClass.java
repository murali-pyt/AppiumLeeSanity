package com.at.runner;

import org.testng.TestNG;

import com.at.pickyourtrailApp.test.AppItineraryCreationTest;

public class PYTAppRunnerClass {
	static TestNG testNg;

	public static void main(String[] args) {
		testNg = new TestNG();
		testNg.setTestClasses(new Class[] {AppItineraryCreationTest.class});
		testNg.run();
	}

}
