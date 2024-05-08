package com.orangehrm.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import static javax.swing.text.html.CSS.getAttribute;

public class FindLinks {
    public static void main(String arg[]) throws IOException {
        CommonFunctions commonFunctions = new CommonFunctions();
        WebDriver driver = commonFunctions.launchBrowser("chrome");
        driver.get("https://www.amazon.in/");
        List<WebElement> webElementList = driver.findElements(By.tagName("a"));
        //iterate through the list to get element
        for (WebElement element : webElementList) {
            String link = element.getAttribute("href");
            if(link !=null && !link.startsWith("javascript")){
                //convert string url into actual url
                URL url=new URL(link);
                //opening connection for an url using port
                URLConnection  connection= url.openConnection();
                //cast connection var into HttpURLConnection
                HttpURLConnection urlConnection=(HttpURLConnection)  connection;
                //hit the url
                urlConnection.connect();
                //get status code
                int statusCode= urlConnection.getResponseCode();
                if(statusCode==200){
                    System.out.println("Broken Url: " + statusCode +  " " + link);

                }

            }

        }
        driver.quit();
    }
}
