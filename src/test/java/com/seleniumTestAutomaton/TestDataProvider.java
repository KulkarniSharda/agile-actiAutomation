package com.seleniumTestAutomaton;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

public class TestDataProvider {

	@DataProvider(name = "LoginData")
	public Object[][] provideLoginData() {

		Object[][] obj1 = new Object[][] {

				{ "1", "username1", "password1" },
				{ "2", "username2", "password2" }

		};
		return obj1;
	}


}
