package com.at.runner;

import org.testng.TestNG;

import com.at.pickyourtrailApp.test.FluidAppTest;

public class FluidAppRunner {

	static TestNG testNg;

	public static void main(String[] args) {
		testNg = new TestNG();
		testNg.setTestClasses(new Class[] {FluidAppTest.class});
		testNg.run();
	}

}
