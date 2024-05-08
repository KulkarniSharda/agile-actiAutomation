package com.proorangeHrm;


import com.automateFramework.baseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage extends baseClass {
	
	public LoginPage(WebDriver driver){
		
		PageFactory.initElements(driver, LoginPage.class);
	}

	// username locator
//	By username = By.id("txtUsername");

	// password locator
//	By password = By.id("txtPassword");

	// login button
//	By loginButton = By.xpath("//input[@id='btnLogin']");

	// forgotPasswordLink
	By forgotPasswordLink = By.xpath("//div[@id='forgotPasswordLink']/a");
	
	//Reset Password Button
	By resetPasswordButton= By.id("btnSearchValues");
	
	By forgetPasswordUsername= By.id("securityAuthentication_userName");
	
	@FindBy(id="txtUsername")
	public WebElement username;
	
	@FindBy(id="txtPassword")
	public WebElement password;
	
	@FindBy(xpath="//input[@id='btnLogin']")
	public WebElement loginButton;
	

	/**
	 * This method will perform the login operation based on provided username and
	 * password
	 */
	public void loginToOrangeHrm(String username, String password) {

		this.username.sendKeys(username);

		this.password.sendKeys(password);

		loginButton.click();

	}
	
	
	/**
	 * This method will to reset the password for orange hrm website
	 */
	public void forgotPassword(String username) {
		
		driver.findElement(forgotPasswordLink).click();
		
		Assert.assertTrue(driver.findElement(resetPasswordButton).isDisplayed());
		
		driver.findElement(forgetPasswordUsername).sendKeys(username);
		
		driver.findElement(resetPasswordButton).click();			
		
	}

}
