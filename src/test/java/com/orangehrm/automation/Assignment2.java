package com.orangehrm.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Assignment2 {
    public static void main(String[] args) {
        ChromeOptions options = new ChromeOptions();
        options.setBrowserVersion("121");
        options.addArguments("--remote-allow-origins=*");//Assignment
        WebDriver driver = new ChromeDriver(options);
        //navigate to url
        driver.get("https://online.actitime.com/cybersuccess7/");
        //maximize the browser window
        driver.manage().window().maximize();
        //locate and click on login button
        WebElement loginButton= driver.findElement(By.id("loginButton"));
        loginButton.click();
        //locate and click on add new project button
        WebElement addNewProjectButton= driver.findElement(By.id("addNewProjectButton"));
        addNewProjectButton.click();
        //locate project name and description input fields
        WebElement projectNameField= driver.findElement(By.id("projectNameField"));
        projectNameField.click();
        WebElement projectDescriptionField= driver.findElement(By.id("projectDescription"));
        //clear project name and description fields(if contain any prefill data)
        projectNameField.clear();
        projectDescriptionField.clear();
        //submit the form(assuming theirs separate submit button)
        WebElement submitButton= driver.findElement(By.id("submitBuuton"));
        submitButton.click();
        //use action class to handle alert message
        Actions actions=new Actions(driver);
            //close the browser
        driver.quit();
        //assignment for blank description and blank project name using action class





    }
}
