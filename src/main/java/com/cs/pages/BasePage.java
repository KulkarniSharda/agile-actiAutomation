package com.cs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cs.constants.Frameworkconstants;
import com.cs.driver.DriverManager;
import com.cs.enums.WaitStrategy;
import com.cs.factories.ExplicitWaitFactory;
import com.cs.reports.ExtentLogger;
 

public class BasePage {
	
	protected void click(By by, WaitStrategy waitStrategy, String elementName) 
	{
		WebElement element = ExplicitWaitFactory.performExplicitWait(waitStrategy, by);
		ExtentLogger.pass("clicked on " + elementName);
		element.click();
	}
	
	protected void sendKeys(By by, String value, WaitStrategy waitStrategy, String elementName) 
	{
		WebElement element = ExplicitWaitFactory.performExplicitWait(waitStrategy, by);	 
		ExtentLogger.pass(value + " is entered in " + elementName);
		element.sendKeys(value);
	}
	protected String getPageTitle() {
		return DriverManager.getDriver().getTitle();
	}
	
	private static void explicitlyWaitforElementToBeClickable(By by)
	{
		WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Frameworkconstants.getExplicitwait() );
		wait.until(ExpectedConditions.elementToBeClickable(by));
	}
	
	private static void explicitlyWaitForElementToBePresent(By by)
	{
		WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Frameworkconstants.getExplicitwait());
		wait.until(ExpectedConditions.presenceOfElementLocated(by));
	}
	private static void explicitlyWaitForElementToBeVisible(By by)
	{
		WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Frameworkconstants.getExplicitwait());
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}

	private static void explicitlyWaitforElement(By by, WaitStrategy waitStrategy)
	{
			if (waitStrategy == WaitStrategy.PRESENCE)
				explicitlyWaitForElementToBePresent(by);
			else if (waitStrategy == WaitStrategy.CLICKABLE)
				explicitlyWaitforElementToBeClickable(by);
			else if (waitStrategy == WaitStrategy.VISIBLE)
				explicitlyWaitForElementToBeVisible(by);
			else 
				explicitlyWaitForElementToBePresent(by);
			
	}

	
	

}



