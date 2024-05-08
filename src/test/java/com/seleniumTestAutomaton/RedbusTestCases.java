package com.seleniumTestAutomaton;

import java.time.LocalDateTime;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.automateFramework.*;
import static com.automateFramework.baseClass.launchBrowser;

public class RedbusTestCases extends baseClass {
	WebDriver driver;
	@BeforeTest
	@Parameters({"Browser"})
	public void beforeTest(@Optional ("Chrome") String Browser) {

		driver=launchBrowser(Browser);
		
	}
	@BeforeClass
	public void beforeClass() {

		driver.navigate().to("https://paytm.com");

	}

	@BeforeMethod
	public void beforeMethod() {

		System.out.println("This is before method");

	}

	@AfterMethod
	public void afterMethod() {

		System.out.println("This is after method");
	}

	@Test
	public void verifyTheTitle() {

		System.out.println("Test1");

	}

	@Test(dependsOnMethods = { "verifyTheTitle" })
	public void verifyUrl() {

		System.out.println("Test2");

	}

	@Test(dependsOnMethods = { "verifyUrl" })
	public void closeBrowser() {

		System.out.println("Test3");

	}

	@AfterClass
	public void afterClass() {
		closeBrowserInstance();
	}

}
