package com.cs.pages;

import org.openqa.selenium.By;

import com.cs.driver.DriverManager;
import com.cs.enums.WaitStrategy;

public class OrangeHRMLoginPage extends BasePage {

	// locators
	private static final By username = By.name("username");
	private static final By password = By.name("password");
	private static final By loginBtn = By.xpath("//button[@type='submit']");

	public OrangeHRMLoginPage enterUsername(String un) {
		sendKeys(username, un,WaitStrategy.PRESENCE, "USERNAME");
		return this;
	}

	public OrangeHRMLoginPage enterPassword(String pw) {
		sendKeys(password, pw, WaitStrategy.PRESENCE, "PASSWORD");
		return this;
	}

	public OrangeHRMHomepage clickLoginBtn() {
		click(loginBtn,WaitStrategy.CLICKABLE, "LOGIN BUTTON" );
		return new OrangeHRMHomepage();
	}

	public String getTitle() {
		return getPageTitle();
	}

}