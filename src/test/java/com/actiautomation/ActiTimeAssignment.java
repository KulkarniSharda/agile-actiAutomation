package com.actiautomation;

import com.actitime.automation.pages.BaseClass;
import com.actitime.automation.pages.TaskPages;
import com.automateFramework.CommonFunction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ActiTimeAssignment extends BaseClass{
    CommonFunction commonFunction;
    LoginPage loginPage;
    TaskPages taskPages;
    WebDriver driver;
    @BeforeClass
    public void browserSetup() throws InterruptedException {
        commonFunction = new CommonFunction(driver);
        loginPage = new LoginPage(driver);
        TaskPages Taskpages = new TaskPages(driver);
        driver = launchBrowser("chrome");


        //launch the browser
        ChromeOptions options = new ChromeOptions();
        options.addArguments("121");
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        //navigate to url
        driver.get("https://online.actitime.com/yshindole1");


        Thread.sleep(10000);
    }
    @BeforeMethod
            public void beforeMethod() throws InterruptedException {
        loginPage.login("yashshindole10@gmail.com", "yash@123");


        driver.findElement(By.id("username")).sendKeys("yashshindole10@gmail.com");
        driver.findElement(By.name("pwd")).sendKeys("yash@123");
        WebElement loginButton = driver.findElement(By.id("loginButton"));
        loginButton.click();
        Thread.sleep(3000);
        //navigate to customer and task
    }
    @Test
            public void Assignment() throws InterruptedException{
        WebElement customersAndTasksTab = driver.findElement(By.id("ext-gen24"));
        customersAndTasksTab.click();
        Thread.sleep(50000);
        //select project and filter task
        WebElement projectDropdown = driver.findElement(By.id("customerAndProjectSelectorExt-gen23"));
        projectDropdown.click();
        //locate and select project
        WebElement projectOption = driver.findElement(By.xpath("//div[text()='Project Name']"));
        Thread.sleep(3000);
        //filter task by status
        WebElement statusDropdown = driver.findElement(By.xpath("td[text()='Status']/following-sibling::td//img"));

        statusDropdown.click();
        driver.findElement(By.xpath("//span[text()='selected']")).click();

        WebElement newStatusOption = driver.findElement(By.xpath("//div[text()='New']"));
        newStatusOption.click();
        //select all task with new status
        WebElement selectAllCheckbox = driver.findElement(By.xpath("selectAllCheckbox"));
        selectAllCheckbox.click();
        Thread.sleep(3000);
        //change status to planning
        WebElement changeStatusButton = driver.findElement(By.id("changeStatusButton"));
        changeStatusButton.click();
        Thread.sleep(5000);
        WebElement planningOption = driver.findElement(By.xpath("//option[text()='Planning']"));
        planningOption.click();
        Thread.sleep(3000);
        //apply planning status
        WebElement applyButton = driver.findElement(By.xpath("//span[text()='Apply']"));
        applyButton.click();
        WebElement planningStatus = driver.findElement(By.xpath("//td[text()='planning']"));
        if (planningStatus.isDisplayed()) {

            System.out.println("Tasks successfully changed to Planning status");
        } else {
            System.out.println("Tasks could not be changed to Planning status");
        }


        {

        }
    }

        public void tearDown () throws InterruptedException {
           // driver.quit();
        }

    }

