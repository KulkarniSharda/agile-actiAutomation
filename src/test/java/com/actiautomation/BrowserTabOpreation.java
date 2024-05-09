package com.actiautomation;

import com.actitime.automation.pages.BaseClass;
import com.actitime.automation.pages.TaskPages;
import com.automateFramework.CommonFunction;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class BrowserTabOpreation extends BaseClass{
    CommonFunction commonFunction;

    LoginPage loginPage;
    TaskPages taskpage;
    WebDriver driver;
    @BeforeClass
    public void browserSetup() throws InterruptedException {
        commonFunction = new CommonFunction(driver);
        loginPage = new LoginPage(driver);
        taskpage = new TaskPages(driver);

        //launch browser

        driver = launchBrowser("chrome");
        driver.get("https://online.actitime.com/yshindole/");
        Thread.sleep(5000);
    }
    @BeforeMethod
    public void beforemethod() {
        loginPage.login("yashshindole10@gmail.com", "yash@123");

    }
    @Test
            public void browserTab(){




        WebElement actiTimeLink= driver.findElement(By.partialLinkText("actiTime"));
        Actions actions=new Actions(driver);
        actions.contextClick(actiTimeLink).build().perform();
        actions.keyDown(Keys.ARROW_DOWN).build().perform();
        actions.keyUp(Keys.ARROW_DOWN).build().perform();
        actions.keyDown(Keys.ENTER).build().perform();
        actions.keyUp(Keys.ENTER).build().perform();
        //print title of login page
        System.out.println("Title of login page:"+driver.getTitle());
        //switch control from loginpage to newly open tab
        String loginWindowId= driver.getWindowHandle();
        System.out.println("Login Window Id:"+loginWindowId);
        //get ids of all window
        Set<String> allWindowIDs=driver.getWindowHandles();
        System.out.println(allWindowIDs);
        //iterate through the set and check login window idif it is loginwindowid
        //then ignore it and print other one
        for (String id:allWindowIDs){
            if (!id.equals(loginWindowId))
            System.out.println("Second Tab/Window Id:"+id);
            //jump control to second tab
            driver.switchTo().window(id);
            System.out.println("Second Tab Title: "+driver.getTitle());
            //close the second tab
           // driver.close();
            //switch  control back to login page
            driver.switchTo().window(loginWindowId);
            //print title of current page
            System.out.println("Current page Title:"+driver.getTitle());
            //open new window and switch the control
            //driver.switchTo().window(loginWindowId);
            //open new tab and switch the control
            //driver.switchTo().window(WindowType.TAB); */
        }


    }
    public void tearDown() throws InterruptedException{
        driver.quit();

    }
}
