package com.actiautomation;

import com.actitime.automation.pages.BaseClass;
import com.actitime.automation.pages.TaskPages;
import com.automateFramework.CommonFunction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.*;


public  class ActitimeCustomerCreationTest extends BaseClass{
        CommonFunction commonFunction;
        LoginPage loginPage;
        TaskPages taskPages;

        WebDriver driver;

        @BeforeClass
        public void setup() throws InterruptedException {
            commonFunction = new CommonFunction(driver);
            loginPage = new LoginPage(driver);
            TaskPages takspages = new TaskPages(driver);
            driver=launchBrowser("chrome");
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
        }
        @BeforeMethod
                public void beforeMethod() throws InterruptedException{

            loginPage.login("yashshindole10@gmail.com", "yash@123");

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



