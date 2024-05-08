package com.orangehrm.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class CreateCustomerAutomation {
    public static void main(String[] arg) throws InterruptedException {
        //launch browser
        //1. create an instance of ChromeOptions class
        ChromeOptions options = new ChromeOptions();
        options.setBrowserVersion("121");
        options.addArguments("--remote-allow-origins=*");
        //2 create an instance of chrome driver and pass chrome option instance
        // refrence to chromedriver constructor
        WebDriver driver = new ChromeDriver(options);
        Thread.sleep(10000);
        //navigate to url
        driver.get("https://online.actitime.com/cybersuccess7/");
        //maximizing the browser
        driver.manage().window().minimize();
        //locating and clicking on login button
        WebElement loginButton= driver.findElement(By.id("loginButton"));
        loginButton.click();
        //Entering username and password
        WebElement usernameField= driver.findElement(By.id("yashshindole10@gmail.com"));

        Thread.sleep(5000);
        WebElement passwordField= driver.findElement(By.id("yash@123"));
        Thread.sleep(3000);
        usernameField.sendKeys("CyberSuccess@yopmail.com");
        Thread.sleep(5000);
        passwordField.sendKeys("yash@123");
        Thread.sleep(10000);
        //locating and clicking on submitbutton
        WebElement submitButton= driver.findElement(By.id("submitButton"));
        submitButton.click();
        //navigating to customer creation page
        WebElement customersTab= driver.findElement(By.id("customersTab"));
        Actions actions=new Actions(driver);
        actions.moveToElement(customersTab).click().build().perform();
        WebElement createCustomerOption= driver.findElement(By.id("createCustomerOption"));
        actions.moveToElement(createCustomerOption).click().build().perform();


    }
}