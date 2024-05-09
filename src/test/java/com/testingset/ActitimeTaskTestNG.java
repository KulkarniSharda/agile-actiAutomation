package com.testingset;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;




    public class ActitimeTaskTestNG {
        WebDriver driver;
        @BeforeClass
        public void setup() throws InterruptedException{
            ChromeOptions options = new ChromeOptions();
            options.setBrowserVersion("121");
            options.addArguments("--remote- allow-origins=*");

            driver.get("https://online.actitime.com/yshindole1");
            Thread.sleep(7000);
            WebElement usernameField = driver.findElement(By.id("username"));
            WebElement passwordField = driver.findElement(By.name("pwd"));
            WebElement loginButton = driver.findElement(By.id("loginButton"));
            usernameField.sendKeys("yashshindole10@gmail.com");
            passwordField.sendKeys("yash@123");
            loginButton.click();//take this in before class
            //wait for dashboard to load
            //wait
            Thread.sleep(5000);

        }
        @Test
        public void createTask () throws InterruptedException{
            Thread.sleep(3000);
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
        @AfterTest
        public void tearDown(){
            // close the browser
            driver.quit();

        }


    }



