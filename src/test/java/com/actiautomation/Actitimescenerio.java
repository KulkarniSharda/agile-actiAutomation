package com.actiautomation;

import com.actitime.automation.pages.BaseClass;
import com.actitime.automation.pages.TaskPages;
import com.automateFramework.CommonFunction;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Actitimescenerio extends BaseClass{
    WebDriver driver;
    CommonFunction commonFunction;
    TaskPages taskPages;
    LoginPage loginPage;

    @BeforeClass
    public void beforeclass() throws InterruptedException {
        commonFunction = new CommonFunction(driver);
        driver = launchBrowser("chrome");
        loginPage = new LoginPage(driver);
        TaskPages TaskPages = new TaskPages(driver);


        ChromeOptions options = new ChromeOptions();
        options.setBrowserVersion("121");
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        //navigate to url
        driver.get("https://online.actitime.com/yshindole1");
    }
    @BeforeMethod
            public void beforeMethod() {
        loginPage.login("yashshindole10@gmail.com", "yash@123");
        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.name("pwd"));
        WebElement loginButton = driver.findElement(By.id("loginButton"));
        usernameField.sendKeys("yashshindole10@gmail.com");
        passwordField.sendKeys("yash@123");
        loginButton.click();
    }
    @Test
            public void scnerio(){
        //navigate to project page
        driver.findElement(By.id("container_tasks")).click();

        //click on add new button
        driver.findElement(By.id("ext-gen23")).click();//this is id for add new button


        //click on add new project button
        driver.findElement(By.id("ext-gen106")).click();//this is id for add new  project button

        //Hnadle the alert
        Alert alert=driver.switchTo().alert();

        //click on cancel button
        alert.dismiss();

        //close the browser


        //scenerio for without entering anything on project click on cancel button

    }
    public void tearDown(){
        driver.quit();
    }
}
