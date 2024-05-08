package com.orangehrm.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.security.Key;

public class AmazonAssignment {
    public static  void main(String[] args) throws Exception{
        CommonFunctions commonFunctions=new CommonFunctions();
        WebDriver driver= commonFunctions.launchBrowser("chrome");
        driver.get("https:/www.amazon.in");
        driver.manage().window().maximize();
        Thread.sleep(5000);
        Actions actions=new Actions(driver);
        actions.contextClick(driver.findElement(By.xpath("//a[text()='Amazon miniTV']"))).build().perform();
        Thread.sleep(3000);
        actions.keyDown(Keys.ARROW_DOWN).build().perform();
        actions.keyUp(Keys.ARROW_DOWN).build().perform();
        actions.keyDown(Keys.ENTER);
        Robot robot=new Robot();
        robot.keyPress(KeyEvent.VK_PAGE_DOWN);
        robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
        robot.mouseWheel(500);
    }
}
