package com.cs.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import com.cs.driver.Driver;
import com.cs.driver.DriverManager;

public final class LoginTests extends BaseTest
{
	private LoginTests() {}
	
	@Test
	public void test1() throws InterruptedException
	{
		DriverManager.getDriver().findElement(By.name("q")).sendKeys("Cyber Success", Keys.ENTER);
		
		Thread.sleep(3000l);
	}
	
	@Test
	public void test2() throws InterruptedException
	{
		DriverManager.getDriver().findElement(By.name("q")).sendKeys("Best java classes in pune", Keys.ENTER);
		
		Thread.sleep(3000l);
	}
}





