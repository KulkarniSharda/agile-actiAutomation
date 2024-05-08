package SeleniumFramework;

import org.testng.annotations.Test;

public class DataProvider {


  @org.testng.annotations.DataProvider (name="Provide")
  public Object[][] dp() {

		Object[][] obj = new Object[][] {

				{ 1 }, { 2 }, { 3 }, { 4 }, { 5 }

		};

		/*
		 * obj[0][0] = 1; obj[0][1] = 2; obj[0][2] = 3; obj[0][3] = 4; obj[0][4] = 5;
		 */

		System.out.println(obj);

		return obj;

  }
  

	@Test(dataProvider = "Provide")
	public void method1(Object value) {

		System.out.println(value);
	}
}
