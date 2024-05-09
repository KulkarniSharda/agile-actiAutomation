package com.actiautomation;

import com.actitime.automation.pages.BaseClass;
import com.actitime.automation.pages.TaskPages;
import com.automateFramework.CommonFunction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;

public class Scenerios extends BaseClass{
    CommonFunction commonFunction;
    LoginPage loginPage;
    TaskPages taskPages;
    WebDriver driver;
    @BeforeClass
    public void browsersetup() throws  InterruptedException{
        commonFunction=new CommonFunction(driver);
        loginPage=new LoginPage(driver);
        TaskPages taskpages=new TaskPages(driver);
       driver =launchBrowser("chrome");



   // public static void main(String[] arg) throws InterruptedException{
        //launch the browser
        ChromeOptions options = new ChromeOptions();
        options.addArguments("121");
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        //navigate to url
        driver.get("https://online.actitime.com/yshindole1");

        Thread.sleep(10000);

        driver.findElement(By.id("username")).sendKeys("yashshindole10@gmail.com");
        driver.findElement(By.name("pwd")).sendKeys("yash@123");
        WebElement loginButton = driver.findElement(By.id("loginButton"));
        loginButton.click();
        //navigate to customer
        driver.findElement(By.xpath("//input[@id=customerLightBox_content]/div[2]/div[1]/div/div[1]/div[1]/input]")).click();

        Thread.sleep(3000);
        //select customer from dropdown
        driver.findElement(By.xpath("//div[@class=dropdownButton]")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//div[text()=Create Customer]")).click();
        Thread.sleep(2000);

    }
}
