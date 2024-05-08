package com.orangehrm.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class ProjectCreation {
    public static void main(String[] args){
        ChromeOptions options = new ChromeOptions();
        options.setBrowserVersion("121");
        options.addArguments("--remote-allow-origins=*");//Assignment
        WebDriver driver = new ChromeDriver(options);
        //navigate to url
        driver.get("https://online.actitime.com/cybersuccess7/");
        //maximize the browser window
        driver.manage().window().maximize();
        //enter username password click on login button
        WebElement usernameField= driver.findElement(By.id("username"));
        usernameField.sendKeys("yashshindole10@gmail.com");
        WebElement passwordField= driver.findElement(By.name("pwd"));
        passwordField.sendKeys("yash@123");
        WebElement loginButton= driver.findElement(By.id("loginButton"));
        loginButton.click();
        //find task menu item and hover over it
        WebElement taskMenuItem= driver.findElement(By.id("container_tasks"));
        Actions actions=new Actions(driver);
        actions.moveToElement(taskMenuItem).build().perform();
        //find and click on the project and customers option from dropdown
        WebElement projectsCustomersOption=driver.findElement(By.xpath("//div[@class='menu_icon_projects']"));
        projectsCustomersOption.click();
        //wait for some time the projects page to load
          // Thread.sleep(3000);
           //find and click on create new project
         WebElement createNewProjectButton= driver.findElement(By.xpath("//div[@class='addNewContainer']//div[@class='addNewButton"));
         createNewProjectButton.click();
         //fill out project details
        WebElement projectNameField= driver.findElement(By.xpath("//input[@placeholder='Enter Project Name']"));
        projectNameField.sendKeys("Project Name");
        //save project
        WebElement createProjectButton= driver.findElement(By.xpath("//div[@class='buttonIcon']"));
        createProjectButton.click();
        //close the browser
        driver.quit();




    }

}
