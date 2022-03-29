package com.crm.autodeskgenericUtility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
/**
 * This class contains implementation for ITestListener interface of TestNG
 * @author vijayalaxmi
 *
 */
public class ListenerImplementationClass implements ITestListener{
	
	ExtentTest test;
	ExtentReports report;

    public void onTestStart(ITestResult result) {
    	//Step3:create a test method during the test execution starts
    	test=report.createTest(result.getMethod().getMethodName());
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+"---------->start");
		
			}
    String path=null;
	public void onTestSuccess(ITestResult result) {
		//Step4:log the pass method
		test.log(Status.PASS, result.getMethod().getMethodName());
		test.log(Status.FAIL, result.getThrowable());
		//String path=null;
		WebDriverUtility wUtil=new WebDriverUtility();
		try {
			path=wUtil.takesScreenshot(BaseClass.sDriver, result.getMethod().getMethodName());
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test.addScreenCaptureFromPath(path);
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+"------>execution successful");
			}
	

	public void onTestFailure(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+"execution failed");
		System.out.println(result.getThrowable());
		try {
			 path=new WebDriverUtility().takesScreenshot(BaseClass.sDriver,methodName);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
			}

	public void onTestSkipped(ITestResult result) {
		//Step 5:log the skip method(test case name and exception logs)
		test.log(Status.SKIP, result.getMethod().getMethodName());
		test.log(Status.SKIP, result.getThrowable());
		
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+"--------------->execution skipped");
		System.out.println(result.getThrowable());
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	public void onStart(ITestContext context) {
		//Step1:Extent report configuration
		ExtentSparkReporter htmlReporter = new ExtentSparkReporter("./ExtentReports.html"+new JavaUtility().getSystemDateTime());
		htmlReporter.config().setReportName("Regression execution report");
		htmlReporter.config().setDocumentTitle("comcast automation execution report");
		htmlReporter.config().setTheme(Theme.DARK);
		System.out.println("execution started");
		
		//step2: attach the physical report and do the system configuration
		report = new ExtentReports();
		report.attachReporter(htmlReporter);
		report.setSystemInfo("OS", "Windows 10");
		report.setSystemInfo("Environment", "Testing Environment");
		report.setSystemInfo("URL", "hettps://localhost:8888");
		report.setSystemInfo("ReporterName", "Vijayalaxmi");
		
	}

	public void onFinish(ITestContext context) {
		System.out.println("execution finish");
		report.flush();
	}
	

}
