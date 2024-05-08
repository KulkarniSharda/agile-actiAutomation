package com.actiTestAutomation;

import com.orangehrm.automation.CommonFunctions;
import com.orangehrm.automation.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest1 {
    WebDriver driver;

    @BeforeClass
    public void setup()  throws InterruptedException {
        CommonFunctions commonFunctions=new CommonFunctions();
        driver=commonFunctions.launchBrowser("chrome");
        driver.get("https://opensource-demo.orangehrmlive.com");
        Thread.sleep(10000);

    }
    @Test(dataProvider = "LoginTest1")
    public void verifyLogin(Object username, Object password, Object status) throws Exception{
        LoginPage loginPage=new LoginPage(driver);
        loginPage.login(username.toString(), password.toString());
        Thread.sleep(10000);
        //verify if login  to application  successfully with valid credentials
        if(Boolean.parseBoolean(status.toString())){
            //locate dashboard text and get dashboard text
            WebElement dashboard=driver.findElement(By.xpath("//h6[text()='Dashboard']"));
            String dashboardText=dashboard.getText();
            System.out.println(dashboardText);
            //verify dashboard text value
            if(dashboardText.equals("Dashboard")){
                System.out.println("Successfully landed on dashboard module");

            }else{
                throw new Exception("Unable login to application");

            }
            //perform logout opreation
            loginPage.logout();
            Thread.sleep(10000);
        }else{
            String errorMsg=driver.findElement(By.xpath("//*[text()='Invalid credentials']")).getText();
             loginPage.verifyErrorMsg(errorMsg);
             driver.navigate().refresh();
             Thread.sleep(5000);
        }

    }
    @DataProvider
    public Object [][] LoginTestTestNGData(){
        Object [][] obj=new Object[][]{
                {"Admin", "admin123", true},
                {"Admin", "admin", false},
                {"", "", false}
        };
        return obj;


    }



}

