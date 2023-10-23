package com.at.runner;

import org.testng.TestNG;
import org.testng.annotations.Listeners;

import com.at.pickyourtrailApp.test.ItineraryCreationTest;
import com.qa.allurelistener.TestAllureListener;

@Listeners({TestAllureListener.class})
public class RunnerClass {
	
	static TestNG testNg;

	public static void main(String[] args) {
		testNg = new TestNG();
		testNg.setTestClasses(new Class[] {ItineraryCreationTest.class});
		testNg.run();
	}

}
