package com.actiautomation;

import com.actitime.automation.pages.BaseClass;
import com.actitime.automation.pages.TaskPages;
import com.automateFramework.CommonFunction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;


public class DragAndDropOpreation extends BaseClass{
    WebDriver driver;
    CommonFunction commonFunction;
    LoginPage loginPage;
    TaskPages taskPages;
    @BeforeClass
    public void browsersetup() throws InterruptedException {


        commonFunction = new CommonFunction(driver);
    }
    @BeforeMethod
    public void beforeMethod() throws InterruptedException{
        loginPage.login("yashshindole10@gmail.com", "yash@123");

        driver=launchBrowser("chrome");
        driver.get("https://www.globalsqa.com/demo-site/draganddrop/");
        //switch control from webpage to iframe
        WebElement iframeElement= driver.findElement(By.xpath("//iframe[@class='demo-frame lazyloaded']"));
        //switch to iframe
        driver.switchTo().frame(iframeElement);
        Actions actions=new Actions(driver);
        WebElement srcElement=driver.findElement(By.xpath("//ul[@id='gallery']/li[1]/img"));
        WebElement dstElement= driver.findElement(By.id("trash"));
        //perform drag and drop opreation
       // actions.dragAndDrop(srcElement,dstElement).build().perform();
        actions.clickAndHold(srcElement).release(dstElement).build().perform();
        //switch control back to main page
        driver.switchTo().defaultContent();
        //print title of webpage
        String title= driver.getTitle();
        System.out.println(title);

    }


    }

