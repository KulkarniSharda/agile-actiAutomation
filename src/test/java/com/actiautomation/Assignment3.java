package com.actiautomation;


import com.automateFramework.BrowserBaseClass;
import com.automateFramework.CommonFunction;
import com.automateFramework.TaskPages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Assignment3 extends BrowserBaseClass {
    CommonFunction commonFunction;
    LoginPage loginPage;
    TaskPages taskPages;


    WebDriver driver;

    @BeforeClass
    public void setup() throws InterruptedException {
        commonFunction=new CommonFunction(driver);
        driver = launchBrowser("chrome");
        driver.get("https://online.actitime.com/yshindole1");
        Thread.sleep(7000);
        driver.findElement(By.id("username")).sendKeys("yashshindole10@gmail.com");
        driver.findElement(By.name("pwd")).sendKeys("yash@123");
        WebElement loginButton = driver.findElement(By.id("loginButton"));
        loginButton.click();
        Thread.sleep(5000);
    }
    @Test
    public void AssignmentTask() throws InterruptedException{
        //locate and click on task tab
        WebElement tasksTab=driver.findElement(By.id("tasksTab"));
        tasksTab.click();

        Thread.sleep(3000);

        //locate and click on add new task button
        WebElement addNewTaskButton=driver.findElement(By.id("//div[@class='item createNewTasks']"));
        addNewTaskButton.click();
        Thread.sleep(5000);
        //enter invalid data for task
        WebElement tasknameField=driver.findElement(By.id("taskName"));
        tasknameField.sendKeys("Invalid Task");

        //click on save button
        WebElement saveButton=driver.findElement(By.id("saveTaskButton"));
        saveButton.click();

        //wait
        Thread.sleep(5000);
        //check if error message is displayed
        WebElement errorMessage=driver.findElement(By.className("errorMessage"));
        //chek if error message is displayed indicating invalid data
       // if(errorMessage.getText().contains("invalid data");
        {
            System.out.println("Error message displayed:invalid data entered");
       // }else{

            System.out.println("Error:invalid data error message not  displayed");
        }





    }
    public void tearDown() throws  InterruptedException{
        driver.quit();

    }

}
//adding task with invalid data an error message should be displayed indicating that enter data is invalid