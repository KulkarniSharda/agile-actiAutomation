package com.orangehrm.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ActiTestCaseTest{
    WebDriver driver;
    @BeforeClass
    public void browserSetup() throws InterruptedException{
        CommonFunctions commonFunctions=new CommonFunctions();
        driver= commonFunctions.launchBrowser("chrome");
        driver.get("https://online.actitime.com/yshindole1");
        Thread.sleep(5000);



    }
    @Test
    public void ChangeTaskStatus() throws Exception {
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[text()='Tasks']")).click();
        driver.findElement(By.xpath("//div[text()='Flight opreation'[1]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[text()='New Status']/following::div[7]")).click();
        driver.findElement(By.xpath("//div[text()='New Status']/following::div[contains(text()='Planning']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//span[text()='Apply']")).click();
        String planningStatus = driver.findElement(By.xpath("//div[text()='Planning'])[1]")).getText();
        String str = "planning";
        if (planningStatus.equals(str)) {
            System.out.println("status Changed as planning");
        } else {
            throw new Exception("status not  changed as planning");
        }
    }
    @AfterClass
    public void tearDown(){
        driver.quit();
    }
    }


