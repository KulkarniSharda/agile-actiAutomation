package com.actiautomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LoginTestNew
{

    public static void main(String[]arg) throws Exception {
        //Launch the browser
        ChromeOptions options=new ChromeOptions(); //capablities
        options.setBrowserVersion("121");
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver=new ChromeDriver(options);

        //navigate to url
        driver.get("https://opensource-demo.orangehrmlive.com/");
        Thread.sleep(10000);
        LoginPage loginPage=new LoginPage(driver);
        //perform login opreation
        loginPage.login( "Admin", "admin123");

        //wait the dashboard module is loaded completly
        Thread.sleep(10000);

        //locate the dashboard text and get the text
        WebElement dashboard=driver.findElement(By.xpath("//h6[text()='Dashboard']"));
        String dashboardText = dashboard.getText();
        System.out.println(dashboardText);
        //verify the dashboardtext value
        if (dashboardText.equals("Dashboard")) {
            System.out.println("Successfully landed on dashboard module");

        }else {
            throw new Exception("Unable login to application");
        }
        //perform logout opreation
        loginPage.logout();
        Thread.sleep(5000);
        //enter invalid username valid password
        loginPage.login("24323432", "admin123");
        String errorMsg=driver.findElement(By.xpath("//*[text()='Invalid credentials']")).getText();
        loginPage.verifyErrorMsg(errorMsg);
        driver.navigate().refresh();
        Thread.sleep(5000);
        //enter valid username and invalid password
        loginPage.login("admin", "322432");
        errorMsg=driver.findElement(By.xpath("//*[text()='Invalid credentials']")).getText();
        loginPage.verifyErrorMsg(errorMsg);
        driver.navigate().refresh();
        Thread.sleep(5000);
        loginPage.login("", "");


    }



}
