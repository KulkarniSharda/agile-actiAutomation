package com.orangehrm.automation;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Actitimescenerio {
    public static void main(String[] args){
        ChromeOptions options = new ChromeOptions();
        options.setBrowserVersion("121");
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        //navigate to url
        driver.get("https://online.actitime.com/yshindole1");
        WebElement usernameField= driver.findElement(By.id("username"));
        WebElement passwordField= driver.findElement(By.name("pwd"));
        WebElement loginButton= driver.findElement(By.id("loginButton"));
        usernameField.sendKeys("yashshindole10@gmail.com");
        passwordField.sendKeys("yash@123");
        loginButton.click();
        //navigate to project page
        driver.findElement(By.id("container_tasks")).click();

        //click on add new button
        driver.findElement(By.id("ext-gen23")).click();//this is id for add new button


        //click on add new project button
        driver.findElement(By.id("ext-gen106")).click();//this is id for add new  project button

        //Hnadle the alert
        Alert alert=driver.switchTo().alert();

        //click on cancel button
        alert.dismiss();

        //close the browser
        driver.quit();

        //scenerio for without entering anything on project click on cancel button

    }
}
