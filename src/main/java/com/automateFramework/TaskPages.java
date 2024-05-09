package com.automateFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class TaskPages {

    WebDriver driver;
    public  TaskPages (WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);

    }
    public By taskModule=By.xpath("//div[text()='Tasks']");
    public By logoutButton=By.xpath("//a[text()='Logout'])[1]");
    public By mypracticeproject=By.xpath("//div[text()='My Practise Task'])[1]");
    public By galaxyCorporation=By.xpath("//div[text()='Galaxy Corporation'])[2]");
    public By flightOpreation=By.xpath("//div[text()='Flight opreation'][1]");


}
