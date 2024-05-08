package com.automateFramework;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


public class ExtentAutomationReport extends baseClass {
    /**
     * This method will generate the reports at the specified location and also contains
     * the sys info (Browser, Environment, Url etc).
     * It will return the ExtentReports class reference to initialize
     * the reference veriable which is declared in the base class
     */
    public static ExtentReports getExtentReport() {

        ConfigProperties config = new ConfigProperties();

        String xmlFilePath = System.getProperty("user.dir") + "src/main/java/Reporting/extentReportConfig.xml";

        File file = new File(xmlFilePath);

        //initialize  extentReports reference veriable
        //	extentReports= new ExtentReports(System.getProperty("user.dir")+ "/target/ExtentReport/ExtentReport.html");

        extentReports = new ExtentReports();

        ExtentSparkReporter sparkReport = new ExtentSparkReporter(System.getProperty("user.dir") + "/target/ExtentReport/ExtentReport.html");

        extentReports.attachReporter(sparkReport);

        extentReports.setSystemInfo("Browser", config.getProperty("browser"));

        extentReports.setSystemInfo("Environment", config.getProperty("Environment"));

        extentReports.setSystemInfo("Url", config.getProperty("url"));

        extentReports.setSystemInfo("username", config.getProperty("username"));

        extentReports.setSystemInfo("password", config.getProperty("password"));

        //loading the extent report xml file to extentReports class instance
//		extentReports.loadConfig(file);		

        return extentReports;
    }

    /**
     * The Start Test method will generate the logs for the defined method.
     * The logger reference veriable declared in base class will initialized by calling this method.
     */
    /*
     * public static ExtentTest startTest(String methodName) {
     *
     * logger= extentReports.startTest(methodName);
     *
     * return logger;
     *
     * }
     */
    public static ExtentTest createTest(String methodName) {

        logger = extentReports.createTest(methodName);

        return logger;

    }


}
