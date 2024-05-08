package SeleniumFramework;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

public class DataProviderTesting {
  @Test(dataProvider = "dp")
  public void f(String n, String s) {
	  
	  System.out.println(n + s);
  }

  @DataProvider
  public Object[][] dp() {
   
	  Object [][] obj= new Object[3][5];
		
		obj[0][0]="Username1";
		obj[0][1]="Password1";
		obj[1][0]="Username2";
		obj[1][1]="Password2";
		
		return obj;
  
  };
  }
