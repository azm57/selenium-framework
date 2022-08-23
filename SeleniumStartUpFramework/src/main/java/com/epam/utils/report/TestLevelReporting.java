package com.epam.utils.report;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.epam.fixtures.ScreenshotUtil;

public class TestLevelReporting implements ITestListener {

	@Override

	public void onStart(ITestContext arg0) {

		System.out.println("Start Of Execution(TEST)->" + arg0.getName());

	}

	@Override

	public void onTestStart(ITestResult arg0) {

		System.out.println("Test Started->" + arg0.getName());

	}

	@Override

	public void onTestSuccess(ITestResult arg0) {

		System.out.println("Test Pass->" + arg0.getName());

	}

	@Override

	public void onTestFailure(ITestResult arg0) {

		ScreenshotUtil.getScreenshot();

		System.out.println("Test Failed->" + arg0.getName());

	}

	@Override

	public void onTestSkipped(ITestResult arg0) {

		System.out.println("Test Skipped->" + arg0.getName());

	}

	@Override

	public void onFinish(ITestContext arg0) {

		System.out.println("END Of Execution(TEST)->" + arg0.getName());

	}

	@Override

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {

		// TODO Auto-generated method stub

	}

}