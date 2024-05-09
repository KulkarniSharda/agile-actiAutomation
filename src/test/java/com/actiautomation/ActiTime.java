package com.actiautomation;

import com.actitime.automation.pages.BaseClass;
import com.actitime.automation.pages.TaskPages;
import com.automateFramework.CommonFunction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.List;

public class ActiTime extends BaseClass {
    CommonFunction commonFunction;
    LoginPage loginPage;
    TaskPages taskPage;

    WebDriver driver;

    @BeforeClass

    public void Setup() throws InterruptedException {
        commonFunction = new CommonFunction(driver);
        loginPage = new LoginPage(driver);
        TaskPages TaskPages = new TaskPages(driver);
        driver = launchBrowser("chrome");
        driver.get(("https://online.actitime.com/cybersuccess7/"));





        loginPage.login("yashshindole10@gmail.com", "yash@123");


        Actions actions = new Actions(driver);

        actions.sendKeys(driver.findElement(By.id("username")), "yashshindole10@gmail.com").build().perform();






        //enter text in password section
        actions.click(driver.findElement(By.name("pwd"))).sendKeys("yash@123").build().perform();
        actions.moveToElement(driver.findElement(By.id("loginButton"))).click().build().perform();
        //locate and click on task tab


        WebElement tasksTab;
        tasksTab = driver.findElement(By.id("container_tasks"));
        tasksTab.click();
        actions.click(driver.findElement(By.xpath("//div[text()='Spaceship building'])[1]"))).build().perform();
      // Thread.sleep(10000);
       List<WebElement> webElementList=driver.findElements(By.xpath("//tr[contains[@class, 'taskRow')]/td[2]//div[@class='title']"));
       System.out.println(webElementList.size());
       for(WebElement element:webElementList){
           if (element.isDisplayed()) {
               System.out.println(element.getText());
           }else {//
               actions.scrollToElement(element).build().perform();
               System.out.println(element.getText());//

           }

       }
       //selectedcheckbox for task
        WebElement element= driver.findElement(By.xpath("//div[@class='img'])[1]"));
       element.click();
     Thread.sleep(5000);
       //click on move to element
        WebElement moveToButton=driver.findElement(By.xpath("//div[@class='move to Button'][text()='Move To']"));
        moveToButton.click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[@class='dropdownButton'])[1]")).click();
        Thread.sleep(3000);
        //selected customer from dropdown

        driver.findElement(By.xpath("//div[text()='Galaxy Corporation']))[2]")).click();











    }
    @AfterClass
    public void tearDown() throws  InterruptedException{
        driver.quit();
    }
}



