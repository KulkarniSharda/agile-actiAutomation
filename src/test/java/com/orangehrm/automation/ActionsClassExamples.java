package com.orangehrm.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class ActionsClassExamples {
    public static void main(String arg[]) throws InterruptedException{
        CommonFunction commonFunctions=new CommonFunction();

        WebDriver driver= commonFunctions.launchBrowser("chrome");
        driver.get("https://online.actitime.com/cybersuccess7/");
        Thread.sleep(5000);
        Actions actions=new Actions(driver);
        //enter the text in username section
        actions.sendKeys(driver.findElement(By.id("username")),"cybersuccess@yopmail.com").build().perform();
        //enter text in password section
        actions.click(driver.findElement(By.name("pwd"))).sendKeys("Test@1234").build().perform();
        //perform click opreation on login button
        actions.moveToElement(driver.findElement(By.id("loginButton"))).click().build().perform();
       // actions.contextClick(driver.findElement(By.id("loginButton"))).build().perform();
       // actions.contextClick().build().perform();
      //  WebElement link= driver.findElement(By.linkText("actiTIME"));
        WebElement link= driver.findElement(By.partialLinkText("actiTIME"));
        actions.contextClick(link).build().perform();
        //press down arrow key
        actions.keyDown(Keys.ARROW_DOWN).build().perform();
        //relese down arrow key
        actions.keyDown(Keys.ARROW_DOWN).build().perform();
        //press enter button
        actions.keyDown(Keys.ENTER).build().perform();
        //relese enter button
        actions.keyUp(Keys.ENTER).build().perform();
       // actions.scrollByAmount(-100,0).build().perform();
      //  actions.scrollByAmount(0,500).build().perform();
     //   actions.scrollToElement(WebElement).build().perform();


    }
}
