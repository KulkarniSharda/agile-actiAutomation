package com.proorangeHrm;

import com.automateFramework.baseClass;
import org.openqa.selenium.By;



public class DashboardPage extends baseClass {

	//menu Dashboard
	public By dashboardMenu = By.id("menu_dashboard_index");

	//assign leave in dashboard module
	public By assignLeave = By.xpath("//span[text()='Assign Leave']");

	//leave list in dashboard module
	public By leaveList = By.xpath("//span[text()='Leave List']");
	
	
}
