package com.orangehrm.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class DragAndDropOpreation {
    public static void main(String[]arg){
        CommonFunction commonFunctions=new CommonFunction();
        WebDriver driver=commonFunctions.launchBrowser("chrome");
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
