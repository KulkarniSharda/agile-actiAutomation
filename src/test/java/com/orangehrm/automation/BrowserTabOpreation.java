package com.orangehrm.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.util.Set;

public class BrowserTabOpreation {
    public static void main(String[] arg) throws InterruptedException {
        //launch browser
        CommonFunctions commonFunctions=new CommonFunctions();
        WebDriver driver=commonFunctions.launchBrowser("chrome");
        driver.get("https://online.actitime.com/cybersuccess7/login.do");
        Thread.sleep(5000);
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
            driver.close();
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
}
