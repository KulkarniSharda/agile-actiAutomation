package com.actiTestAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TaskTestCase{



    public static void main(String[] args) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("121");
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        //navigate to url
        driver.get("https://online.actitime.com/yshindole1");

       // Thread.sleep(10000);

        driver.findElement(By.id("username")).sendKeys("yashshindole10@gmail.com");
        driver.findElement(By.name("pwd")).sendKeys("yash@123");
        WebElement loginButton = driver.findElement(By.id("loginButton"));
        loginButton.click();



        //navigate to tasks page
        driver.findElement(By.id("container_tasks")).click();
        //click on create new task button
        driver.findElement(By.id("ext-gen23")).click();
        //enter task name
        driver.findElement(By.id("createTasksPopup_newCustomer")).sendKeys("Tasks with speical character");
        //click on create task button
        driver.findElement(By.id("createTasksPopup_commitButton")).click();

        //verify that task is created successfully
        WebElement successMessage=driver.findElement(By.xpath("//div[@class='toasts']//span[contains(text(), has been successfully created.)]"));
        if
        (successMessage.isDisplayed()){
            System.out.println("Task created successfully with description containing speical characters");

        } else{
            System.out.println("Task  creation failed");

        }
        driver.quit();
        // verify that task can be created with description input containing speiacl character




    }


}









