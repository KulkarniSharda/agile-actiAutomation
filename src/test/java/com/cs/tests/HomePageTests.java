package com.cs.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import com.cs.driver.DriverManager;

public final class HomePageTests extends BaseTest{

	private HomePageTests() {}
	
	@Test
	public void test3() throws InterruptedException
	{
		DriverManager.getDriver().findElement(By.name("q")).sendKeys("Cyber Success", Keys.ENTER);
		
		Thread.sleep(3000l);
	}
	
}
