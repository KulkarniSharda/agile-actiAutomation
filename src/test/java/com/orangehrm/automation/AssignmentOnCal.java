package com.orangehrm.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AssignmentOnCal {
    public static void main(String[] arg) throws Exception {
        //launch the browser
        ChromeOptions options = new ChromeOptions();
        options.addArguments("121");
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        //navigate to url
        driver.get("https://online.actitime.com/cybersuccess7/");
        Thread.sleep(10000);

        driver.findElement(By.id("username")).sendKeys("cybersuccess@yopmail.com");
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Test@1234");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[@id='loginButton']/child::div")).click();
        Thread.sleep(10000);
        driver.findElement(By.xpath("//div[text()='Tasks']")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//body/div[@id='taskManagementPage']/div[1]/div[1]/div[2]/div[1]/div[2]div[1]/div[1]/div[2]/div[3]/div[2]/div[1]")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//div[@id='taskListBlock']/descendant::div[10]")).click();
        Thread.sleep(3000);
        WebElement entertask = driver.findElement(By.xpath("//span[text()='Flight opreations']/following::input[1]"));
        entertask.sendKeys("Cyber Success Training");
        driver.findElement(By.xpath("//div[@class='components-Deadline-date--vW8sYsk2 components-deadline-withoutDate--ZujIxVzy']")).click();
        Thread.sleep(3000);
        // driver.findElement(By.xpath("//tbody[@class='rc-calender-tbody']descendant::td[10]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[text()='Type of Work']/following::div[3]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//span[text()='testing']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("body/div[45]/div[1]/div[1]/div[1]/div[1]/div[4]/div[1]/div[3]/div[1]/div[1]")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//tr[@id='ext-gen16']/following::td[3]")).click();
        Thread.sleep(3000);
        String sendName = "Cyber Success Training";
        Thread.sleep(3000);
        WebElement textName = driver.findElement(By.xpath("//div[@title='Cyber Success Training']"));



    }
}