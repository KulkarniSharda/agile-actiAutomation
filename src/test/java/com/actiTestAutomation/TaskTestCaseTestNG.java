

package com.actiTestAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TaskTestCaseTestNG {
    WebDriver driver;

    @BeforeTest
    public void setup() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.setBrowserVersion("121");
        options.addArguments("--remote- allow-origins=*");
        driver.manage().window().maximize();


        //navigate to url
        driver.get("https://online.actitime.com/yshindole1");

        // Thread.sleep(10000);

        driver.findElement(By.id("username")).sendKeys("yashshindole10@gmail.com");
        driver.findElement(By.name("pwd")).sendKeys("yash@123");
        WebElement loginButton = driver.findElement(By.id("loginButton"));
        loginButton.click();
    }

    @Test
    public void createTask() {
        //navigate to tasks page
        driver.findElement(By.id("container_tasks")).click();
        //click on create new task button
        driver.findElement(By.id("ext-gen23")).click();
        //enter task name
        driver.findElement(By.id("createTasksPopup_newCustomer")).sendKeys(("Task with speical character"));

        //enter task description with speical character String


        //click on create task button
        driver.findElement(By.id("createTasksPopup_commitButton")).click();


        //verify that task is created successfully
        WebElement successMessage = driver.findElement(By.xpath("//div[@class='toasts']//span[contains(text(), has been successfully created.)]"));
        if
        (successMessage.isDisplayed()) {
            System.out.println("Task created successfully with description containing speical characters");

        } else {
            System.out.println("Task  creation failed");

        }


        }



        }










