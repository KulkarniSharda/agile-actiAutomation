package com.testingset;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ActiTimeAutomation {
    WebDriver driver;

    @BeforeClass
    public void setup() throws  InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.setBrowserVersion("121");
        options.addArguments("--remote- allow-origins=*");
        driver.manage().window().maximize();


        //navigate to url
        driver.get("https://online.actitime.com/yshindole1");

         Thread.sleep(10000);

        driver.findElement(By.id("username")).sendKeys("yashshindole10@gmail.com");
        driver.findElement(By.name("pwd")).sendKeys("yash@123");
        WebElement loginButton = driver.findElement(By.id("loginButton"));
        loginButton.click();
    }

    @Test
    public void Test(){
        //navigate to Task creation
        WebElement tasksTab=driver.findElement(By.id("tasksTab"));
        tasksTab.click();

        WebElement newTaskButton=driver.findElement(By.id("createTasksButton"));
        newTaskButton.click();
        //create task with empty description
        WebElement taskNameField=driver.findElement(By.id("createTasks Popup_crateTasksTableContainer_createTasksTable_crateTasksTable_0 _nameField"));

        // Thread.sleep(5000);
        WebElement createButton=driver.findElement(By.id("crateTasksPopup_createTasksTable_commitBtn"));
        taskNameField.sendKeys("Task with empty description");
        createButton.click();
        //verify task creation
        WebElement task=driver.findElement(By.xpath("//div[@class='taskNameColumn']//div[contains(text()='Task with empty description']"));
        String description= task.getAttribute("title");
        if(description.equals("")){
            System.out.println("Task created successfully with empty description");
        //    else{
                System.out.println("Task creation failed");
            }

        }
        //verify that task can be created with empty description field

    }





