package com.testingset;



import com.actiautomation.CommonFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;





    public class ActiTestCase4 {
        WebDriver driver;
        @BeforeClass
        public void setUp() throws InterruptedException {
            CommonFunctions commonFunctions=new CommonFunctions();
            driver=commonFunctions.launchBrowser("chrome");
            driver.get("https://online.actitime.com/oncospark");
            commonFunctions.loginForActitime();
            driver.manage().window().maximize();
            Thread.sleep(3000);
        }

        @Test
        public void customerToTask() throws InterruptedException {
            driver.findElement(By.xpath("//div[text()='Tasks']")).click();
            driver.findElement(By.xpath("//div[text()='Add New']")).click();
            driver.findElement(By.xpath("//div[text()='+ New Customer']")).click();
            Thread.sleep(3000);
            //give customer name
            driver.findElement(By.xpath("//div[@class='customerNameDiv']/child::input")).sendKeys("Mahindra Company1");
            Thread.sleep(3000);
            driver.findElement(By.xpath("//div[text()='Create Customer']")).click();
            Thread.sleep(3000);

            //create project under above customer
            driver.findElement(By.xpath("//div[text()='Add New']")).click();
            driver.findElement(By.xpath("//div[text()='+ New Project']")).click();
            Thread.sleep(3000);
            driver.findElement(By.xpath("//div[@class='sectionDetails']/child::input[1]")).sendKeys("Mahindra Projects1 ");
            Actions actions = new Actions(driver);
            for (int i = 0; i < 5; i++) {
                // Send the DOWN arrow key to scroll down
                actions.sendKeys(Keys.DOWN).perform();
                driver.findElement(By.xpath("//div[text()='Create Project']")).click();
                Thread.sleep(3000);
            }
        }

        @Test(dataProvider = "getTaskData")
        public void verifyTask(String taskname,String status) throws InterruptedException {
            //create tasks
            driver.findElement(By.xpath("(//div[text()='Add Task'])[1]")).click();
            driver.findElement(By.xpath("(//input[@placeholder='Enter Task Name'])[2]")).sendKeys(taskname);
            Thread.sleep(5000);
            driver.findElement(By.xpath("(//div[text()='Add Task'])[3]")).click();
            Thread.sleep(5000);
            if(status.equals("valid1")) {
                String myFirstTask = driver.findElement(By.xpath("(//div[text()='MyTask'])[1]")).getText();
                if (myFirstTask.equals("MyTask")) {
                    System.out.println("Test case is passed for creation of first task ");
                } else {
                    System.out.println("Test case is failed for first task");
                }
            } else if(status.equals("valid2")){
                String mySecondTask = driver.findElement(By.xpath("(//div[text()='Task@#$'])[1]")).getText();
                if(mySecondTask.equals("Task@#$")){
                    System.out.println("Test case is passed for creation of second task ");
                } else {
                    System.out.println("Test case is failed for second task");
                }
            } else if(status.equals("valid3")){
                String myThirdTask = driver.findElement(By.xpath("(//div[text()='Task Name is TASK 4'])[1]")).getText();
                if(myThirdTask.equals("Task Name is TASK 4")){
                    System.out.println("Test case is passed for creation of third task ");
                } else {
                    System.out.println("Test case is failed for third task");
                }
            }
        }

        @DataProvider
        public Object[][] getTaskData(){
            Object [][]a=new Object[][]{
                    {"MyTask","valid1"},
                    {"Task@#$","valid2"},
                    {"Task Name is TASK 4","valid3"}
            };
            return a;
        }
    }



