package com.actiautomation;

import org.testng.annotations.*;

public class TaskTest {
    @BeforeGroups(groups = "sanity")
    public void beforeSanityGroups() {
        System.out.println("This is before sanity groups method.....");

    }

    @BeforeGroups(groups = "regression")
    public void beforeRegressionGroup() {
        System.out.println("This is before regression groups method....");
    }

    @AfterGroups(groups = "regression")
    public void afterRegressionGroup() {
        System.out.println("This is after regression groups method....");
    }

    @BeforeSuite(groups = "regression")
    public void beforesuite() {
        System.out.println("This is before suite method...");
    }

    @BeforeTest(groups = "regression")
    public void beforetest() {
        System.out.println("This is before test method...");
    }

    @AfterTest(groups = "regression")
    public void afterTest() {
        System.out.println("This is after test method....");

    }

    @AfterSuite(groups = "regression")
    public void afterSuite() {
        System.out.println("This is after suite method....");
    }

    @BeforeMethod(groups = "regression")
    public void beforeMethod() {
        System.out.println("This is before method....");
    }

    @AfterMethod(groups = "regresssion")
    public void afterMethod() {
        System.out.println("This is after method...");
    }

    @BeforeClass(groups = "regression")
    public void beforeClass() {
        System.out.println("This is before class method....");
        // logic to launch browser
    }

    @AfterClass(groups = "regression")
    public void afterClass() {
        System.out.println("This is after class method....");
    }

    @Test(groups = "regression")
    public void test1() {
        System.out.println("This is test1 method of TaskTest class");
    }

    @Test(groups = "sanity")
    public void test2() {
        System.out.println("Thsi is test2 method of TaskTest class ");
    }

    @Test(groups = {"sanity", "regression"})
    public void test3() {
        System.out.println("This is test3 method of TaskTest class");
    }
}



