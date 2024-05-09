package com.actiautomation;

import com.actitime.automation.pages.BaseClass;
import com.actitime.automation.pages.TaskPages;
import com.automateFramework.CommonFunction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.LocalDateTime;
import java.util.List;

public class DatePickerExamples extends BaseClass{

    WebDriver driver;
    CommonFunction commonFunction;
    LoginPage loginPage;
    TaskPages taskPages;
    @BeforeClass
    public void browsersetup() throws  InterruptedException {


        commonFunction = new CommonFunction(driver);


        driver = launchBrowser("chrome");
       // driver.get("https://online.actitime.com/cybersuccess7/");
        Thread.sleep(5000);
    }
    @BeforeMethod
            public void BeforeMethod() throws InterruptedException {
        loginPage.login("yashshindole10@gmail.com", "yash@123");

        //Get current day of month
        int dayOfMonth = LocalDateTime.now().getDayOfMonth();
        System.out.println("Day of month is:" + dayOfMonth);
        String currentMonth = LocalDateTime.now().getMonth().name();
        String actualCurrentMonth = currentMonth.charAt(0) + currentMonth.substring(1, currentMonth.length()).toLowerCase();
        System.out.println("Current month is: " + actualCurrentMonth);

        ChromeOptions options = new ChromeOptions();
        options.setBrowserVersion("121");
        options.addArguments("--remote-allow-origins=*");
         driver = new ChromeDriver(options);
        //navigate to url
        driver.get("https://online.actitime.com/yshindole1");
        //click on calender
        driver.findElement(By.id("username")).sendKeys("yashshindole10@gmail.com");
        driver.findElement(By.name("pwd")).sendKeys("yash@123");
        driver.findElement(By.id("loginButton")).click();
        Thread.sleep(5000);
    }
    @Test
            public void DatePicker() throws InterruptedException{
        driver.findElement(By.id("container_tasks")).click();
        //click on project
        driver.findElement(By.xpath("//div[text()='Flight opreations']")).click();
        //click on add task button
        driver.findElement(By.xpath("//div[@class='rightContainer']")).click();
        driver.findElement(By.xpath("//div[@class='detailsRow']/descendant::div[text='Set up deadline']")).click();
        String actualCurrentMonth = null;
        String monthXpath = "//td[starts-with@title,'" + actualCurrentMonth + " ')]/div";
        System.out.println(monthXpath);
        List<WebElement> days = driver.findElements(By.xpath(monthXpath));
        for (WebElement dayElement : days) {
            String day = dayElement.getText();
            System.out.println(day);
            //check if the day value is equals with day of month then select that day
            //also convert dayOfMonth into string for comparison
            int dayOfMonth = 0;
            if (day.equals(String.valueOf(dayOfMonth))) {
                dayElement.click();

            }


        }
    }
    @AfterClass
    public void tearDown(){
        driver.quit();

    }
}

