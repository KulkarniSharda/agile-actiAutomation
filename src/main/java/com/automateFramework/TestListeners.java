package com.automateFramework;


import com.aventstack.extentreports.Status;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.*;

import java.io.File;
import java.io.IOException;

public class TestListeners  extends baseClass implements ITestListener, ISuiteListener {

	public void onTestStart(ITestResult result) {

		System.out.println("This is on test start method from TestListeners class :" + result.getMethod().getMethodName());
//		ExtentAutomationReport.startTest(result.getMethod().getMethodName());
		
		ExtentAutomationReport.createTest( result.getMethod().getMethodName());
	}

	public void onTestSuccess(ITestResult result) {

		System.out.println("This is onTestSuccess method from TestListeners class "+ result.getStatus());
		
		
//		logger.log(LogStatus.PASS, result.getMethod().getMethodName());
		
		logger.log(Status.PASS, result.getMethod().getMethodName());
		

	}

	public void onTestFailure(ITestResult result) {

		
//		logger.log(LogStatus.FAIL, result.getMethod().getMethodName()+ "****Exception is**** : " + result.getThrowable());
		
		logger.log(Status.FAIL, result.getMethod().getMethodName()+ "****Exception is**** : " + result.getThrowable());
		
		System.out
				.println("This is onTestFailure method from TestListeners class" + result.getMethod().getMethodName());
		
		ConfigProperties config=new ConfigProperties();
		
		String screenshotFilePath=config.getProperty("ScreenShotFilePath")+"/"+result.getMethod().getMethodName()+result.getEndMillis()+".png";

		try {

			TakesScreenshot takeScreenShot = (TakesScreenshot) driver;

			File file = takeScreenShot.getScreenshotAs(OutputType.FILE);

			FileUtils.copyFile(file, new File(screenshotFilePath));
			
			
			//attache the screen shot in extent report at the runtime
//			logger.log(LogStatus.INFO, logger.addScreenCapture(screenshotFilePath));
			
			 logger.addScreenCaptureFromPath(screenshotFilePath);

		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public void onTestSkipped(ITestResult result) {
		
//		logger.log(LogStatus.SKIP, result.getMethod().getMethodName());
		
		logger.log(Status.SKIP, result.getMethod().getMethodName());

		System.out.println("This is onTestSkipped method from TestListeners class");

	}
	
	public  void onTestFailedButWithinSuccessPercentage(ITestResult result) {

			System.out.println("This is  onTestFailedButWithinSuccessPercentage method");
			
//			logger.log(LogStatus.PASS, "This is  onTestFailedButWithinSuccessPercentage method "+result.getMethod().getMethodName());
		
	}

	public void onStart(ITestContext context) {

		
		System.out.println("This is onStart method from TestListeners class");
		
		ExtentAutomationReport.getExtentReport();

	}

	public void onFinish(ISuite suite) {

		System.out.println("This is onFinish method from TestListeners class");
		
		extentReports.flush();
		closeBrowserInstance();
	}

}
