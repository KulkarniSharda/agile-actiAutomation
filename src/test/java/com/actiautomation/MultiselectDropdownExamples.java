package com.actiautomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class MultiselectDropdownExamples
{

    public static void main(String args[]){
        ChromeOptions options=new ChromeOptions();
        options.setBrowserVersion("121");
        options.addArguments("remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(options);
        driver.get("https://letcode.in/dropdowns");
        WebElement dropdown= driver.findElement(By.id("superheros"));
        Select select= new Select(dropdown);
        //get all options present in dropdown
        List<WebElement> allOptions=select.getOptions();
        //print all options present in dropdown using for loop
        for (int i=0;i< allOptions.size();i++) {

            WebElement option=allOptions.get(i);

            String text= option.getText();
            System.out.println(text);
        }
        select.deselectByValue("hb");
        //select iron man fromdropdown
        select.selectByVisibleText("Iron Man");
        //select Hellboy from dropdown
        // select.selectByVisibleText("Hellboy");

        //select Batman from dropdown
        select.selectByVisibleText("bt");
        //print all selected value
        List<WebElement> allSelectedOptions =select.getAllSelectedOptions();
        System.out.println("******** All Selected Options**********");
        //iterate through allSelectedOptions to get text from each element
        for (int i=0; i<allSelectedOptions.size(); i++){
            WebElement webElement=allSelectedOptions.get(i);
            String text= webElement.getText();
            System.out.println(text);

        }


    }



}
