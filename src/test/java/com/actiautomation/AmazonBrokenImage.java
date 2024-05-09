package com.actiautomation;

import com.actitime.automation.pages.BaseClass;
import com.actitime.automation.pages.TaskPages;
import com.automateFramework.CommonFunction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class AmazonBrokenImage extends BaseClass{
    CommonFunction commonFunction;
    LoginPage loginPage;
    TaskPages taskpage;
    WebDriver driver;
    @BeforeClass
    public void browsersetup() throws  InterruptedException{
        commonFunction=new CommonFunction(driver);
        loginPage=new LoginPage(driver);
        taskpage=new TaskPages(driver);


        driver= launchBrowser("chrome");
       // driver.get("https://online.actitime.com/yshindole1");
        Thread.sleep(5000);
    }
    @BeforeMethod
    public void beforemethod() {
        loginPage.login("yashshindole10@gmail.com", "yash@123");


        driver = launchBrowser("chrome");
        driver.get("https://www.amazon.in/");
    }
    @Test
            public void BrokenImage() throws Exception{
            List<WebElement> images=driver.findElements(By.tagName("img"));
            //loop through each image and validate its source
            for (WebElement image: images) {
                String imageUrl = image.getAttribute("src");

                if(imageUrl !=null && !imageUrl.isEmpty()) {
                    try {
                        URL url = new URL(imageUrl);
                        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                        connection.setRequestMethod("GET");
                        connection.connect();
                        int responseCode = connection.getResponseCode();
                        if (responseCode != HttpURLConnection.HTTP_OK) {
                            System.out.println("Broken Image: " + imageUrl);

                        }
                        connection.disconnect();
                    }catch (IOException e){


//void printStackTrace();

                    }

                }






                    }


        }
         @AfterClass
    public void tearDown() throws InterruptedException{
        driver.quit();;

         }
                }







