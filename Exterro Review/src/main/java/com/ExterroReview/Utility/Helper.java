package com.ExterroReview.Utility;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Helper 
{	
	
	public static String captureScreenshot(WebDriver driver)
	{
		TakesScreenshot ts= (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		
		String screenshotPath=System.getProperty("user.dir")+"/Screenshot/"+ Helper.currentDateTime() +".png";
		
		try 
		{
			FileHandler.copy(source, new File(screenshotPath));
			System.out.println("Screenshot captured");
			 
		} 
		catch (Exception e) 
		{
			
			System.out.println("Exception in capturing Screenshot>>>>" +e.getMessage());
		}
		
		return screenshotPath;
	}
	
	
	/*Actual code for Screenshot:
		
		TakesScreenshot ts= (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		try 
		{
			FileHandler.copy(source, new File("./Screenshot/"+ Helper.currentDateTime() +".png"));
		} 
		catch (Exception e) 
		{
			
			System.out.println("Exception in capturing Screenshot" +e.getMessage());
		}*/
	
		
	
	
	public static String currentDateTime()
	{
		DateFormat customFormat =new SimpleDateFormat("dd_MM_yyyy_HH_mm_ss");
		Date currentDate=new Date();
		return customFormat.format(currentDate);		
	}
}
