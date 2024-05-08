package com.cs.pages;

import org.openqa.selenium.By;

import com.cs.enums.WaitStrategy;

public final class PIMPage extends BasePage
{
	
	//locators
	private static final By AddBtn = By.xpath("//div[@id='app']//div[2]/div[1]/button");
	
	public PIMPage ClickOnAddBtn()
	{
		click(AddBtn, WaitStrategy.CLICKABLE, "ADD CUSTOMER BUTTON");
		return this;
	}
	


}
