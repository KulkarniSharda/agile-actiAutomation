package com.proorangeHrm;

import com.automateFramework.baseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class LeavePage extends baseClass {
	
	public LeavePage(WebDriver driver){
		
		PageFactory.initElements(driver, LeavePage.class);
	}

	@FindBy(xpath="//a[@id='menu_leave_viewLeaveModule']")
	public WebElement leaveMenu;
	
	@FindBy(id="menu_leave_applyLeave")
	public WebElement applyModule;
	
	@FindBy(id="menu_leave_viewMyLeaveList")
	public WebElement myLeaveModule;
	
	@FindBy(id="menu_leave_Entitlements")
	public WebElement entitlementModule;
	
	@FindBy(id="menu_leave_Reports")
	public WebElement reportsModule;
	
	@FindBy(id="menu_leave_assignLeave")
	public WebElement assignLeave;
	
	@FindBy(xpath="//div[@id='apply-leave']/div[1]/h1")
	public WebElement applyLeaveText;

}
