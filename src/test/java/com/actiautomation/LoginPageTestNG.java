package com.actiautomation;
import com.automateFramework.BrowserBaseClass;
import com.automateFramework.CommonFunction;
import com.automateFramework.TaskPages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginPageTestNG extends BrowserBaseClass {
    CommonFunction commonFunction;
    LoginPage loginPage;
    TaskPages taskPages;

    WebDriver driver;
    @BeforeTest
    public void setup() throws InterruptedException{
      //  WebDriver driver;
        CommonFunctions commonFunctions = new CommonFunctions();
         driver = launchBrowser("chrome");
        ChromeOptions options=new ChromeOptions();
        options.setBrowserVersion("121");
        options.addArguments("--remote- allow-origins=*");

         driver=new ChromeDriver(options);
        driver.get("https://online.actitime.com/yshindole1");
        driver.manage().window().maximize();

        Thread.sleep(2000);
    }
    @Test
    public void loginPage() throws InterruptedException{

            this.driver = driver;
        }

        public void login(String username,String password) {

            driver.findElement(By.name("yashshindole10@gmail.com")).sendKeys(username);
            driver.findElement(By.name("yash@123")).sendKeys(password);
            driver.findElement(By.xpath("//button[@type='submit']")).click();
        }
        public void logout(){
            driver.findElement(By.xpath("//p[@class='oxd-userdropdown-name']/following-sibling::i")).click();
            driver.findElement(By.xpath("//a[text()='Logout']")).click();
        }
        @Test
        public void  verifyErrorMsg(String msg) throws Exception {
            if (msg.equals("Invalid credentials")) {

                System.out.println("Test passed with invalid credentials");
            } else {
                throw new Exception("Test failed: error msg is not displayed on login page with valid credentials");
            }
        }
        @AfterTest
     public void tearDown(){
        driver.quit();

        }
}


