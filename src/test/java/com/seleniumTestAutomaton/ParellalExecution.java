package SeleniumFramework;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.openqa.selenium.By;

public class ParellalExecution extends baseClass {


	@Test(dataProvider = "LoginData", dataProviderClass=TestDataProvider.class)
	public void method1(String srNo,String username, String password) {
		
		
		System.out.println("Sr No: "+ srNo + " username :" + username+ " password :" + password);
	}


}
