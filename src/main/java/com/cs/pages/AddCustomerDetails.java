package com.cs.pages;

import org.openqa.selenium.By;

import com.cs.enums.WaitStrategy;

public final class AddCustomerDetails extends BasePage{

	
	private static final By fName = By.name("firstName");
	private static final By mName = By.name("middleName");
	private static final By lName = By.name("lastName");
	private static final By saveBtn = By.xpath("//button[@type='submit']");
	// to do -> confirmation message 
	
	// methods
	public void enterFName(String firstName)
	{
		sendKeys(fName,  firstName+System.currentTimeMillis(), WaitStrategy.PRESENCE, "FIRSTNAME");
	}
	public void enterMName(String middleName)
	{
		sendKeys(mName,  middleName+System.currentTimeMillis(), WaitStrategy.PRESENCE, "MIDDLENAME");
	}
	
	public void enterLName(String lastName)
	{
		sendKeys(lName,  lastName+System.currentTimeMillis(), WaitStrategy.PRESENCE, "LASTNAME");
	}
	
	public void clickOnSaveBtn()
	{
		click(saveBtn, WaitStrategy.CLICKABLE, "SAVE BUTTON");
	}
	
}
