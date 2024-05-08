package com.seleniumTestAutomaton;

import com.automateFramework.TestListeners;
import com.automateFramework.baseClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;

@Listeners(TestListeners.class)
public class AmazonTestCase extends baseClass {

	/*
	 * @BeforeTest
	 * 
	 * @Parameters({"Browser"}) public void beforeTest(String Browser) {
	 * 
	 * // driver=launchBrowser(Browser);
	 * 
	 * }
	 */

	@BeforeClass(groups = "paytmTest")
	public void beforeClass() {
		
		driver=launchBrowser("Chrome");
		
		Reporter.log("This is before class method");

		driver.get("https://fb.com");
		System.out.println("This is before class");
	}

	@AfterClass(groups = "paytmTest")
	public void afterClass() {
		System.out.println("This is after class");

		Reporter.log("This is after  method");
	
	}

	@BeforeMethod
	public void beforeMethod() {
		
		
		Reporter.log("This is before method");

		System.out.println("This is before method");
		
	}
	
	@Test(groups = "paytmTest", priority = 1)
	public void Test1() throws Exception {

		System.out.println("This is test1 method");
		
		Reporter.log("This is test1 method");
		throw new Exception("This is an exception");
		
	
	}

	@Test(groups = "paytmTest", priority = 2)
	public void A() {

		System.out.println("This is test2 method");
		
		Reporter.log("This is test2 method executed successfully");

	}

}
