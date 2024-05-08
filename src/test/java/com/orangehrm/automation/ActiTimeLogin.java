package com.orangehrm.automation;


import net.bytebuddy.asm.Advice;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


    public class ActiTimeLogin {
        public static void main(String[]arg) throws Exception {
            //launch the browser
            ChromeOptions options=new ChromeOptions();
            options.addArguments("121");
            options.addArguments("--remote-allow-origins=*");
            WebDriver driver=new ChromeDriver(options);
            //navigate to url
            driver.get("https://online.actitime.com/cybersuccess7/");
            Thread.sleep(10000);

            driver.findElement(By.id("username")).sendKeys("yashshindole10@gmail.com");
            driver.findElement(By.name("pwd")).sendKeys("yash@123");
            Thread.sleep(2000);
            driver.findElement(By.xpath("//a[@id='loginButton']/child::div")).click();
            Thread.sleep(10000);
            String timeTrack=driver.findElement(By.xpath("//div[@id='container_tt']/following-sibling::div[1]")).getText();
            System.out.println(timeTrack);
            if (timeTrack.equals("Time-Track")) {
                System.out.println("Successfully landed on Time-Track module");
            }else {
                throw new Exception("Unable to login application");
            }
            Thread.sleep(5000);
            driver.findElement(By.xpath("//div[@class='createdTasksTableContainer']/following::div[28]")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//div[text()='Change Status']")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//div[text()='New Status']/following::div[6]")).click();
            Thread.sleep(3000);
            driver.findElement(By.xpath("//div[text()='click to view project settings']/following::div[28]")).click();
            Thread.sleep(4000);
            driver.findElement(By.xpath("//span[text()='Apply']")).click();
            String statusChange=driver.findElement(By.xpath("//tbody/tr[1]/td[3]/div[1]/div[1]/div[1]/div[3]")).getText();
            System.out.println(statusChange);
            Thread.sleep(5000);
            if(statusChange.equals("Planning")) {
                System.out.println("Status change: " + statusChange);
            }else {
                throw new Exception("Status not change");
            }

        }

    }


































