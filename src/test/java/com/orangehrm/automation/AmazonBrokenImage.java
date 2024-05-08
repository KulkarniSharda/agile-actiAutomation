package com.orangehrm.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

public class AmazonBrokenImage {

        public static void main(String[] args) throws Exception{
            CommonFunctions commonFunctions=new CommonFunctions();
            WebDriver driver= commonFunctions.launchBrowser("chrome");
            driver.get("https://www.amazon.in/");
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
                        e.printStackTrace();

                    }

                }






                    }
                }
            }






