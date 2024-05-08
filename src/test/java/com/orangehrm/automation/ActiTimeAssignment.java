package com.orangehrm.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ActiTimeAssignment {
    public static void main(String[] arg) throws Exception {
        //launch the browser
        ChromeOptions options = new ChromeOptions();
        options.addArguments("121");
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        //navigate to url
        driver.get("https://online.actitime.com/yshindole1");

        Thread.sleep(10000);

        driver.findElement(By.id("username")).sendKeys("yashshindole10@gmail.com");
        driver.findElement(By.name("pwd")).sendKeys("yash@123");
        WebElement loginButton = driver.findElement(By.id("loginButton"));
        loginButton.click();
        Thread.sleep(3000);
        //navigate to customer and task
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
    }else {
        System.out.println("Tasks could not be changed to Planning status");
    }




        {

        }
        driver.quit();


    }

    }

