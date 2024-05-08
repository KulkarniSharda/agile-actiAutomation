package com.orangehrm.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


    public  class ActitimeCustomerCreationTest {
        WebDriver driver;

        @BeforeClass
        public void setup() throws InterruptedException {
            //initialize chrome driver instance
             driver = new ChromeDriver();
            //Maximize the window
             driver.manage().window().maximize();
            //navigate to url
            driver.get("https://online.actitime.com/yshindole1");
            //Entering username and password
            WebElement usernameField = driver.findElement(By.id("yashshindole10@gmail.com"));
            usernameField.sendKeys("yashshindole10@gmail.com");

            Thread.sleep(5000);
            WebElement passwordField = driver.findElement(By.id("yash@123"));
            Thread.sleep(5000);
            WebElement loginButton = driver.findElement(By.id("loginButton"));
            loginButton.click();

        }


        @Test
        public void createCustomer()  {

           // WebDriver driver;








            //locating and clicking on submitbutton
            WebElement submitButton = driver.findElement(By.id("submitButton"));
            submitButton.click();
            //navigating to customer creation page
            WebElement customersTab = driver.findElement(By.id("customersTab"));
            Actions actions = new Actions(driver);
            actions.moveToElement(customersTab).click().build().perform();
            WebElement createCustomerOption = driver.findElement(By.id("createCustomerOption"));
            actions.moveToElement(createCustomerOption).click().build().perform();


        }

        @AfterTest

        public void tearDown() {

          //  WebDriver driver;
            driver.quit();
        }
    }



