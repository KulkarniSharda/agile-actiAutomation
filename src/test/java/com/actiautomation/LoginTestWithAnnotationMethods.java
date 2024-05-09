package com.actiautomation;

import com.automateFramework.CommonFunction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTestWithAnnotationMethods {

    WebDriver driver;
    LoginPage loginPage;
    String error;

    @BeforeClass
    public void launchBrowser() throws Exception {
        //set the browser
        CommonFunction commonFunction = new CommonFunction(driver);
       // driver =launchBrowser("chrome");
        //navigate to browser
        driver.get("https://opensource-demo.orangehrmlive.com");
        //wait
        Thread.sleep(10000);
    }

    @DataProvider
    public Object[][] getTextData() {
        Object[][] obj = new Object[][]{
                {"Admin", "admin123", "test1"},
                {"Admin", "1234", "test2"},
                {"asdfghj", "admin123", "test3"},
                {"", "admin123", "test4"},
                {"Admin", "", "test5"},
                {"", "test6"}


        };
        return obj;


    }
    @Test(dataProvider = "getTextData")
            public void testLogin(Object username, Object password, Object status) throws Exception{
        loginPage=new LoginPage(driver);
        //enter valid username and valid password
        loginPage.login(username.toString(),password.toString());
        String test=status.toString();
        Thread.sleep(10000);
        if(test.equals("test1"))//true
            {
            //navigate to dashboard
            String dashboard=driver.findElement(By.xpath("//h6[text()='Dashboard]")).getText();
            if
            (dashboard.equals(dashboard)){
                System.out.println("Successfully landed on dashboard");

            }else {
                throw new Exception("unable to land on dashboard");
            }
                //logout from application
                loginPage.logout();

                Thread.sleep(5000);

            } else if(test.equals("test2")){
            //navigate to error message and get error text
            driver.findElement(By.xpath("//p[text()='invalid credentials']")).getText();
            //print error message
            loginPage.verifyErrorMsg(error);

            //refresh the page
            driver.navigate().refresh();
            //wait for refresh login page
            Thread.sleep(5000);
        } else if (test.equals("test3")){
            //navigate to error message and get text
            error=driver.findElement(By.xpath("//p[text()='invalid credentials']")).getText();
            //print error message
            loginPage.verifyErrorMsg(error);


            driver.navigate().refresh();
            //wait for refresh login page
            Thread.sleep(50000);

        }else if (test.equals("test4")){
            //navigate to error message and get error message
            driver.findElement(By.xpath("//input[@type='password']/preceding::span")).getText();
            Thread.sleep(5000);
            //print error message
            loginPage.verifyErrorMsg(error);


            //naviagte to login page
            driver.navigate().refresh();
            //wait for refresh login page
            Thread.sleep(5000);
        }else if(test.equals("test5")){
            //wait for error message
            Thread.sleep(5000);
            //navigate to error message and get error text
            error=driver.findElement(By.xpath("//button[@type='submit']/preceding::span")).getText();
            //print error message

            //refresh login page
            driver.navigate().refresh();
            //wait for refresh login page
            Thread.sleep(5000);
        } else if(test.equals("test6")){
            //wait for error message
            Thread.sleep(5000);
            //navigate to error message and get error text
            String error1=driver.findElement(By.xpath("//input[@type='password']/preceding::span")).getText();
            String error2=driver.findElement(By.xpath("//button[@type='submit']/preceding::span")).getText();
            if(error1.equals("Required")&& error2.equals("Required")){
                {
                    System.out.println("With invalid credentials  testing is pass");

                }
              //  else {


                    throw new Exception("invalid test case is fail or appropriate message is no display");
                    }
                }
                }



            }







