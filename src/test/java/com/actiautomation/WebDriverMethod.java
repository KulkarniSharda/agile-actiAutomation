package com.actiautomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebDriverMethod
{
    public static void main(String[]arg) throws InterruptedException{
        //launch browser
        //1. create an instance of ChromeOptions class
        ChromeOptions options=new ChromeOptions();
        options.setBrowserVersion("121");
        options.addArguments("--remote-allow-origins=*");
        //2 create an instance of chrome driver and pass chrome option instance
        // refrence to chromedriver constructor
        WebDriver driver=new ChromeDriver(options);
        //3. navigate to an orangehrm website
        driver.navigate().to("https://opensource-demo.orangehrmlive.com/");
        //4.get title of current page and print the console
        String title= driver.getTitle();
        System.out.println(title);
        String currentUrl= driver.getCurrentUrl();
        System.out.println(currentUrl);
        Thread.sleep(10000);
        LoginPage loginPage=new LoginPage(driver);
        loginPage.login("admin","admin123");
        Thread.sleep(10000);
        driver.findElement(By.xpath("//span[text()='PIM'")).click();
        Thread.sleep(10000);
        WebElement searchEmpName=driver.findElement(By.xpath("//label[text()='Employee Name']/following::input[1]"));
        searchEmpName.sendKeys("Cyber Success");
        searchEmpName.click();
        searchEmpName.clear();

        //navigate to amazon website
        driver.get("https://www.amazon.in/");
        WebElement searchtextbox=driver.findElement(By.id("twotabsearchtextbox"));
        String placeholder=searchtextbox.getAttribute("placeholder");
        System.out.println(placeholder);
        WebElement signIn=driver.findElement(By.id("nav-link-accountList"));
        String href=signIn.getAttribute("href");
        System.out.println(href);
        String tagname=signIn.getTagName();
        System.out.println("Tagname:" +tagname);
        //isDisplayed()
        //if the search box on amazon website is diplayed then enter Mobile text
        if(searchtextbox.isDisplayed()){
            searchtextbox.sendKeys("Mobile");
            searchtextbox.clear();
        }


    }


}




