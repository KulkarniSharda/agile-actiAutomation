package com.orangehrm.automation;

import net.bytebuddy.asm.Advice;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.LocalDateTime;
import java.util.List;

public class DatePickerExamples {
    public static void main(String[] arg) throws InterruptedException {
        //Get current day of month
        int dayOfMonth = LocalDateTime.now().getDayOfMonth();
        System.out.println("Day of month is:" + dayOfMonth);
        String currentMonth = LocalDateTime.now().getMonth().name();
        String actualCurrentMonth = currentMonth.charAt(0) + currentMonth.substring(1, currentMonth.length()).toLowerCase();
        System.out.println("Current month is: " + actualCurrentMonth);

        ChromeOptions options = new ChromeOptions();
        options.setBrowserVersion("121");
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        //navigate to url
        driver.get("https://online.actitime.com/cybersuccess7/");
        //click on calender
        driver.findElement(By.id("username")).sendKeys("cybersuccess@yopmail.com");
        driver.findElement(By.name("pwd")).sendKeys("Test@1234");
        driver.findElement(By.id("loginButton")).click();
        Thread.sleep(5000);
        driver.findElement(By.id("container_tasks")).click();
        //click on project
        driver.findElement(By.xpath("//div[text()='Flight opreations']")).click();
        //click on add task button
        driver.findElement(By.xpath("//div[@class='rightContainer']")).click();
        driver.findElement(By.xpath("//div[@class='detailsRow']/descendant::div[text='Set up deadline']")).click();
        String monthXpath = "//td[starts-with@title,'" + actualCurrentMonth + " ')]/div";
        System.out.println(monthXpath);
        List<WebElement> days = driver.findElements(By.xpath(monthXpath));
        for (WebElement dayElement : days) {
            String day = dayElement.getText();
            System.out.println(day);
            //check if the day value is equals with day of month then select that day
            //also convert dayOfMonth into string for comparison
            if (day.equals(String.valueOf(dayOfMonth))) {
                dayElement.click();

            }


        }
    }
}

