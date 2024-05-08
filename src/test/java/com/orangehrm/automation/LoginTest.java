package com.orangehrm.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LoginTest
{
    public static void main(String[] args) throws Exception{
        ChromeOptions options  = new ChromeOptions();
        options.setBrowserVersion("122");
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);

        //navigate to url
        driver.get("https://opensource-demo.orangehrmlive.com/");

        Thread.sleep(1000);

        //locate username element
        WebElement username = driver.findElement(By.name("username"));
        //enter Admin username in the username element

        username.sendKeys("Admin");

        //locate password element
        WebElement password= driver.findElement(By.name("password"));
        //enter admin123 as password
        password.sendKeys("admin123");
        //locate login button

        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        //click on login button
        loginButton.click();
        //wait the dashboard text and get the text
        WebElement  dashboard= driver.findElement(By.xpath("//h6[text()='Dashboard']"));
        String dashboardText=dashboard.getText();
        System.out.println(dashboardText);
        //verify the dashboardText value
        if (dashboardText.equals("Dashboard")) {
            System.out.println("Successfully landed on dashboard module");

        } else {
            throw new Exception("unable login to application");

        }
        //click on profile section to perform logout
        WebElement profile = driver.findElement(By.xpath("//p[@class='oxd-userdropdown-name']"));
        profile.click();
        driver.findElement(By.xpath("//a[text='Logout']")).click();
        Thread.sleep(1000);
        driver.findElement(By.name("username")). sendKeys("admin");
        //invalid password
        driver.findElement(By.name("password")).sendKeys("asdffgl");

        // click on login
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        driver.navigate().refresh();
        Thread.sleep(5000);
        //navigate to username element and enter invalid username
        driver.findElement(By.name("username")).sendKeys("gwertyuio");
        //navigate to password element and enter valid password
        driver.findElement(By.name("password")).sendKeys("admin123");
        //navigate to login button
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        driver.navigate().refresh();
        Thread.sleep(5000);
        //navigate to user and enter valid name
        driver.findElement(By.name("username")).sendKeys("Admin");
        //navigate to login button and enter
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        driver.navigate().refresh();
        Thread.sleep(5000);
        driver.findElement(By.name("username")).sendKeys("admin123");
        //navigate to login button and click
        driver.findElement(By.xpath("//button[@type='submit']")).click();


    }


}
