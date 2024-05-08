package com.cs.tests;

import org.testng.annotations.Test;

import com.cs.pages.AddCustomerDetails;
import com.cs.pages.OrangeHRMHomepage;
import com.cs.pages.OrangeHRMLoginPage;
import com.cs.pages.PIMPage;

public class CustomerTests extends BaseTest 
{

	@Test
	public void addCustomerTest()
	{
		// Login 
		OrangeHRMLoginPage ohlp = new OrangeHRMLoginPage();
		OrangeHRMHomepage ohhp =  ohlp.enterUsername("Admin")
										.enterPassword("admin123")
										.clickLoginBtn();
		
		PIMPage pp = ohhp.clickOnPIMOption()
						.ClickOnAddBtn();
		
		AddCustomerDetails acd = new AddCustomerDetails();
		acd.enterFName("Cyber");
		acd.enterMName("Success");
		acd.enterLName("Trainer");
		acd.clickOnSaveBtn();

		// to do -> verify confirmation msg
	
	}
	
	
	
}
