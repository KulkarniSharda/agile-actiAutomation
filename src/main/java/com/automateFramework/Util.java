package com.automateFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Util extends baseClass {
	
	
	ConfigProperties properties;
	Wait<WebDriver> wait;
	
	public Util(){
		 properties= new ConfigProperties();
		 wait = new WebDriverWait(driver, Duration.ofSeconds(properties.getProperty("timeout")));
	}
	
	/**
	 * This method will wait for 10 sec until the element is clickable
	 */
	public void WaitElementToBeClickable(By by) {		
		
		wait.until(ExpectedConditions.elementToBeClickable(by));
	}

	/**
	 * This method will wait for 10 sec until the element is visible
	 */
	public void WaitElementToBeVisible(By by) {

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(by)));
	}
	
	/**
	 * This method will wait for 10 sec until the element is visible
	 */
	public void WaitElementToBeVisible(WebElement element) {
		
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	/**
	 * This method will wait for 10 sec until the element is visible
	 */
	public void WaitElementToBeClickable(WebElement element) {
		
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	
}
