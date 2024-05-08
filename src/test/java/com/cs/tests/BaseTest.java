package com.cs.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.cs.driver.Driver;
import com.cs.reports.ExtentReport;
// required
public class BaseTest 
{
	protected BaseTest(){}

	@BeforeMethod
	protected void setUp() throws Exception
	{
		Driver.initDriver();
	}

	@AfterMethod
	protected void tearDown()
	{
		Driver.quitDriver();
	}
	
	
}
