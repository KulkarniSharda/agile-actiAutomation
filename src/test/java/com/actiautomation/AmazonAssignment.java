package com.actiautomation;

import com.actitime.automation.pages.BaseClass;
import com.actitime.automation.pages.TaskPages;
import com.automateFramework.CommonFunction;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AmazonAssignment extends BaseClass{


    CommonFunction commonFunction;
    LoginPage loginPage;
     TaskPages taskapge;
     WebDriver driver;

    @BeforeClass
    public void browserSetup() throws InterruptedException {
        commonFunction = new CommonFunction(driver);
        loginPage = new LoginPage(driver);
        TaskPages taskpage = new TaskPages(driver);
        driver= launchBrowser("chrome");


        driver.get("https://online.actitime.com/yshindole1");
        Thread.sleep(5000);
    }
    @BeforeMethod
            public void beforemethod() throws InterruptedException {

        loginPage.login("yashshindole10@gmail.com", "yash@123");


        driver.get("https:/www.amazon.in");
        driver.manage().window().maximize();
        Thread.sleep(5000);
    }
    @Test
            public void Assignment() throws Exception{

        Actions actions=new Actions(driver);
        actions.contextClick(driver.findElement(By.xpath("//a[text()='Amazon miniTV']"))).build().perform();
        Thread.sleep(3000);
        actions.keyDown(Keys.ARROW_DOWN).build().perform();
        actions.keyUp(Keys.ARROW_DOWN).build().perform();
        actions.keyDown(Keys.ENTER);
       // Robot robot=new Robot();
      //  robot.keyPress(KeyEvent.VK_PAGE_DOWN);
      //  robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
      //  robot.mouseWheel(500);
    }
    @BeforeClass
    public void tearDown() throws InterruptedException{
        driver.quit();
    }

}
