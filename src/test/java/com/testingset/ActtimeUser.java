package com.testingset;

import com.actiautomation.CommonFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;

    public class ActtimeUser {
        WebDriver driver;
        CommonFunctions commonFunctions;
        @BeforeClass
        public void setUp() throws InterruptedException, AWTException {
            commonFunctions = new CommonFunctions();
            driver = commonFunctions.launchBrowser("chrome");
            driver.get("https://online.actitime.com/yshindole");
            WebElement usernameField= driver.findElement(By.id("username"));
            usernameField.sendKeys("yashshindole10@gmail.com");
            WebElement passwordField= driver.findElement(By.name("pwd"));
            passwordField.sendKeys("yash@123");
            WebElement loginButton= driver.findElement(By.id("loginButton"));
            loginButton.click();
        }

        @BeforeMethod
        public void loginActitime() throws AWTException, InterruptedException {
            commonFunctions.loginForActitime();
            driver.manage().window().maximize();
            Robot rbt = new Robot();
            rbt.keyPress(KeyEvent.VK_CONTROL);
            rbt.keyPress(KeyEvent.VK_MINUS);
            rbt.keyRelease(KeyEvent.VK_MINUS);
            rbt.keyPress(KeyEvent.VK_MINUS);
            rbt.keyRelease(KeyEvent.VK_MINUS);
        }

        @Test
        public void usersModule() throws Exception {
            driver.findElement(By.xpath("//div[text()='Users']")).click();
            Thread.sleep(10000);
            driver.findElement(By.xpath("(//span[text()='All Users'])[1]")).click();
            driver.findElement(By.xpath("(//img[@class='x-form-radio'])[2]")).click();
            Thread.sleep(5000);
            driver.findElement(By.xpath("(//span[text()='Meyers, Allison'])[2]")).click();
            driver.findElement(By.xpath("(//span[text()='Apply'])[2]")).click();
            Thread.sleep(5000);
            WebElement mayerText= driver.findElement(By.xpath("(//span[text()='Meyers, Allison'])[1]"));
            mayerText.click();
            String text1=mayerText.getText();
            if(text1.equals("Meyers, Allison")){
                System.out.println("User is successfully created");
            }
            else {
                throw new Exception("user unbale to create successfully ");
            }
            Thread.sleep(8000);
            WebElement text = driver.findElement(By.xpath("(//div[@class='regularRateColumn'])[1]/descendant::input"));
            Actions actions = new Actions(driver);
            actions.scrollToElement(text).build().perform();
            driver.findElement(By.xpath("(//div[@class='regularRateColumn'])[1]/descendant::input")).sendKeys("500");
            driver.findElement(By.xpath("(//div[@class='hideButton_panelContainer'])[1]")).click();
        }
    }

