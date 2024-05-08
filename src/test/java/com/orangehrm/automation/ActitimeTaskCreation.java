package com.orangehrm.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeGroups;

public class ActitimeTaskCreation {
    public static void main(String[] args) {
        // create instance of chrome driver
        WebDriver driver = new ChromeDriver();//before class
        //open actitime application
        driver.get("https://online.actitime.com/cybersuccess7/");
        //locate and fill login credentials
        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.name("pwd"));
        WebElement loginButton = driver.findElement(By.id("loginButton"));
        usernameField.sendKeys("yashshindole10@gmail.com");
        passwordField.sendKeys("yash@123");
        loginButton.click();//take this in before class
        //wait for dashboard to load
        //wait
        //locate and click on task tab
        WebElement tasksTab = driver.findElement(By.id("container_tasks"));//test class
        tasksTab.click();
        //locate and click on new task button

        WebElement newTaskButton = driver.findElement(By.xpath("//div[@class='title ellipsis']"));
        newTaskButton.click();
        //locate and fill in task detail
        WebElement taskNameField = driver.findElement(By.xpath("//input[@placeholder='Enter task name']"));
        taskNameField.sendKeys("Sample Task");
        //create an instance of action class
        Actions actions = new Actions(driver);
        //locate and click create task button
        WebElement createTaskButton = driver.findElement(By.xpath("//div[text()='Create Tasks']"));
        actions.moveToElement(createTaskButton).click().build().perform();
        //verify if task is created successfully
        if (driver.findElement(By.xpath("//div[contains(text()='Task added successfully')]")).isDisplayed()){
        System.out.println("Task created successfully!");
    }      else {
            System.out.println("Failed to create task");
        }
            //close the browser
             driver.quit();
            //verify user able to create task field with valid credentials
        }


    }







