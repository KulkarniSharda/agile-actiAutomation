package com.actiautomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebDriverMethod1
{
    public static void main(String[] arg) {
        //launch browser
        //1.create an instance of Chromeoptions class
        ChromeOptions options = new ChromeOptions();
        options.setBrowserVersion("121");
        //2.create an instance of chrome driver and pass chrome option instance
        //refrence to ChromeDriver constructor
        WebDriver driver = new ChromeDriver(options);


        //3.navigate to amazon website
        driver.get("https://www.amazon.in/");
        WebElement searchtextbox = driver.findElement(By.id("twotabsearchtextbox"));
        String placeholder = searchtextbox.getAttribute("plceholder");
        System.out.println(placeholder);
        WebElement signIn = driver.findElement(By.id("nav-link-accountList"));
        String href = signIn.getAttribute("href");
        System.out.println("href");
        String tagname = signIn.getTagName();
        //isDisplayed()
        //if the search box on amazon website is displayed then enter Mobile text
        if (searchtextbox.isDisplayed()) {
            searchtextbox.sendKeys("Mobile");
            searchtextbox.clear();
        }

    }

}
