package com.automateFramework;

import com.proorangeHrm.DashboardPage;
import com.proorangeHrm.LeavePage;
import com.proorangeHrm.LoginPage;
import com.proorangeHrm.LogoutPage;
import java.util.Objects;



public class PageObjectManager extends baseClass {

	private LoginPage loginPage;
	private LogoutPage logoutPage;
	private DashboardPage dashboardPage;
	private LeavePage leavePage;
	private Util util;

	/**
	 * This method will return the object of LoginPage class. If the LoginPage class
	 * reference variable  is null then in that case it will create new object of the
	 * LoginPage class
	 */
	public LoginPage getLoginpageInstance() {

		return (Objects.isNull(loginPage)) ? new LoginPage(driver) : loginPage;
	}
	

	/**
	 * This method will return the object of LogoutPage class. If the LogoutPage class
	 * reference variable is null then it will create new object of the LogoutPage class
	 *
	 */
	public LogoutPage getLogoutpageInstance() {

		System.out.println(logoutPage);	

		return (Objects.isNull(logoutPage)) ? new LogoutPage() : logoutPage;
	}
	

	/**
	 * This method will return the object of DashboardPage class. If the DashboardPage class
	 * reference variable  is null then in that case it will create new object of the
	 * DashboardPage class
	 */
	public DashboardPage getDashboardpageInstance() {

		return (Objects.isNull(dashboardPage)) ? new DashboardPage() : dashboardPage;
	}
	
	

	/**
	 * This method will return the object of LeavePage class. If the LeavePage class
	 * reference variable  is null then in that case it will create new object of the
	 * LeavePage class
	 */
	public LeavePage getLeavePageInstance() {

		return (Objects.isNull(leavePage)) ? new LeavePage(driver) : leavePage;
	}

	public Util getUtilInstance() {

		return (Objects.isNull(util)) ? new Util() : util;
	}
	
}
