package com.ExterroReview.Utility;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;



public class BaseClass 
{
	public WebDriver driver;
	//public Excel_DataProvider excel;
	public Config_DataProvider config;	
	public ExtentReports report;
	public ExtentTest logger;
	
	@BeforeSuite	
	public void setupSuite()
	{
		Reporter.log("Excel/Config file & Reports are setting up", true);
		
		//excel=new Excel_DataProvider();
		config=new Config_DataProvider();
		
		
		ExtentSparkReporter extent=new ExtentSparkReporter(new File(System.getProperty("user.dir")+"/Reports/"+ Helper.currentDateTime() +".html"));
		report=new ExtentReports();
		report.attachReporter(extent);
		
		
		Reporter.log("Excel/Config file & Reports set up completed", true);
	}
	
	
	@BeforeClass
	public void setup()
	{
		Reporter.log("Starting the Browser", true);
		
		driver = BrowserFactory.StartBrowser(driver, config.getBrowserName(), config.getProdURL_DRP7());
		
		Reporter.log("Browser & App URL is up", true);
	}
	
	
	@AfterClass
	public void tearDown()
	{
		BrowserFactory.quitBrowser(driver);
	}
	
	@AfterMethod
	
	public void tearDownScreenshot(ITestResult tResult) throws IOException
	{
	Reporter.log("Generating Reports & Screenshots", true);
		
		if(tResult.getStatus() == ITestResult.FAILURE)
			{
				//Helper.captureScreenshot(driver);
				//System.out.println("***TEST FAILED*** | Screenshot captured");
			
				logger.fail("*TEST FAILED*",MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
			}
		
		else if(tResult.getStatus() == ITestResult.SUCCESS)
			{
				logger.pass("TEST PASSED",MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
	
			}
				
	
		report.flush();
		Reporter.log("Test Completed", true);
	}
		
	
}
