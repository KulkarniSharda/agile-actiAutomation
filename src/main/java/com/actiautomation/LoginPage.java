package com.actiautomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage
{
    WebDriver driver;
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void login(String username,String password) {
        driver.findElement(By.name("username")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }
    public void logout(){
        driver.findElement(By.xpath("//p[@class='oxd-userdropdown-name']/following-sibling::i")).click();
        driver.findElement(By.xpath("//a[text()='Logout']")).click();
    }
    public void  verifyErrorMsg(String msg) throws Exception {
        if (msg.equals("Invalid credentials")) {

            System.out.println("Test passed with invalid credentials");
        } else {
            throw new Exception("Test failed: error msg is not displayed on login page with valid credentials");
        }
    }


















}
