package com.cs.pages;

import org.openqa.selenium.By;

import com.cs.enums.WaitStrategy;

public final class OrangeHRMHomepage extends BasePage {

	private static final By profilPicArrow = By.xpath("//*[@id='app']//span/img");
	private static final By optionLogout = By.xpath("(//a[@role='menuitem'])[4]");
	private static final By PIMOPtion = By.xpath("//div[@id='app']//ul/li[2]/a");
	
	
	public PIMPage clickOnPIMOption()
	{
		click(PIMOPtion,WaitStrategy.CLICKABLE, "PIM OPTION");
		return new PIMPage();
	}
	
	public OrangeHRMHomepage clickOnProfilePicArrow()
	{
		click(profilPicArrow,WaitStrategy.CLICKABLE, "PROFILE PIC");
		
		return this; 
	}
	public OrangeHRMLoginPage clickOnOptionLogout()
	{
		click(optionLogout,WaitStrategy.CLICKABLE, "LOGOUT OPTION");

		return new OrangeHRMLoginPage();
	}
	
	
	
	
	
	
	
	

	





}
