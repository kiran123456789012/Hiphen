package com.hiphen.crm.generic.ilistener;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.devtools.v128.page.model.Screenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.internal.annotations.IListeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.hiphen.generic.webdriverutility.UtilityClassobject;


public class ListenerImplementation implements ITestListener,ISuiteListener{
	public ExtentReports report;
	ExtentTest test;
	@Override
	public void onStart(ISuite suite) {
		// TODO Auto-generated method stub
		ISuiteListener.super.onStart(suite);
		String time=new Date().toString().replace(" ", "_").replace(":","_");
		ExtentSparkReporter spark=new ExtentSparkReporter("./Advancereport/report+"+time+".html");
		spark.config().setTheme(Theme.DARK);
		spark.config().setDocumentTitle("hiphen TestCases");
		spark.config().setReportName("hiphen automation report");
	    report=new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("os","windows-10");
		report.setSystemInfo("browser","chrome");

	}

	@Override
	public void onFinish(ISuite suite) {
		// TODO Auto-generated method stub
		ISuiteListener.super.onFinish(suite);
		report.flush();
	}

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestStart(result);
	 test = report.createTest(result.getMethod().getMethodName());
	 UtilityClassobject.setTest(test);
	 test.log(Status.INFO, result.getMethod().getMethodName()+"==>Started<==");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSuccess(result);
		 test.log(Status.PASS, result.getMethod().getMethodName()+"==>Completed<==");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String testcase = result.getMethod().getMethodName();
		String time=new Date().toString().replace(" ", "_").replace(":","_");
		TakesScreenshot ts=(TakesScreenshot)(UtilityClassobject.getDriver());
		//TakesScreenshot ts=(TakesScreenshot)(BaseClass.sdriver);
		String filepath= ts.getScreenshotAs(OutputType.BASE64);
		test.addScreenCaptureFromBase64String(filepath,testcase+"_"+time);
		 test.log(Status.FAIL, result.getMethod().getMethodName()+"==>Failed<==");
		/*File src = screenShot.getScreenshotAs(OutputType.FILE);
		File dest=new File("./ScreenShot/"+testcase+time+".png");
		try {
			org.openqa.selenium.io.FileHandler.copy(src, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onFinish(context);
	}
	
	

}
