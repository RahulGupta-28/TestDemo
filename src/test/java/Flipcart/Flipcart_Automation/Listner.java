package Flipcart.Flipcart_Automation;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.IRetryAnalyzer;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import Report.ExtentReport;

public class Listner extends TestBase implements ITestListener{
	
	ExtentReports report=ExtentReport.invokeExtentReport();
	ExtentTest test;
	ThreadLocal<ExtentTest> tl = new ThreadLocal<ExtentTest>();
	
	
	public  void onTestStart(ITestResult result) {
	     test=report.createTest(result.getMethod().getMethodName());
	     tl.set(test);
	  }
	
	public void onTestSuccess(ITestResult result) {
	  System.out.println("Hurray!!!!!!");
	  }
	
	public  void onTestFailure(ITestResult result) {
		
		String filepath = null;
			try {
				 filepath= takeScreenShot((WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance()),result.getMethod().getMethodName());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			tl.get().addScreenCaptureFromPath(filepath);
			tl.get().fail(result.getThrowable());
		} 
	  
	
	public  void onFinish(ITestContext context) {
		report.flush();
	    
	  }
	
	

}
