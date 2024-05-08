package com.orangehrm.automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CommonFunction {
    WebDriver driver;

    //launch the browser
    public WebDriver launchBrowser(String name) {
        if (name.toLowerCase().equals("chrome")) {
            ChromeOptions options = new ChromeOptions();
            options.setBrowserVersion("121");
            options.addArguments("--remote-allow-origins=*");
            driver = new ChromeDriver(options);

        }
        return driver;
    }
}
