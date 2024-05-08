package com.cs.listeners;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.cs.reports.ExtentLogger;
import com.cs.reports.ExtentReport;

public class ListenerClass implements ITestListener, ISuiteListener {

		@Override
		public void onStart(ISuite suite) {
			ExtentReport.initReports();
		}

		@Override
		public void onFinish(ISuite suite) {
			ExtentReport.flushreports();
		}

		@Override
		public void onTestStart(ITestResult result) {
			ExtentReport.createTest(result.getMethod().getMethodName());
		}

		@Override
		public void onTestSuccess(ITestResult result) {
			ExtentLogger.pass(result.getMethod().getMethodName() + " is passed");
		}

		@Override
		public void onTestFailure(ITestResult result) {
			try {
				Thread.sleep(2000l);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			ExtentLogger.fail(result.getMethod().getMethodName() + " is failed");
		}

		@Override
		public void onTestSkipped(ITestResult result) {
			ExtentLogger.skip(result.getMethod().getMethodName() + " is skipped");
		}

		@Override
		public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
			// ignore this method
		}
	}

 
