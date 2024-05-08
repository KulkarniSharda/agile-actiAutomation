package com.proorangeHrm;


import com.automateFramework.Util;
import com.automateFramework.baseClass;
import org.openqa.selenium.By;

public class LogoutPage  extends baseClass {
	
	
	By welcomeIcon= By.id("welcome");
	
	
	By logout=By.xpath("//div[@id='welcome-menu']/descendant::a[4]");
	
	
	public void LogoutFromOrangeHrm() {
		Util util=new Util();
		
		util.WaitElementToBeClickable(welcomeIcon);
		
		driver.findElement(welcomeIcon).click();
		
		util.WaitElementToBeClickable(logout);
		
		driver.findElement(logout).click();
		
	}
	
	

}
