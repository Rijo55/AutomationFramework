package com.ExterroReview.Utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserFactory 
{
	WebDriver driver;
	
	public static  WebDriver StartBrowser(WebDriver driver, String BrowserName, String URL )
	{
		if(BrowserName.equalsIgnoreCase("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver");
			driver=new ChromeDriver();
			
		}
	
		/*else if(BrowserName.equals("Firefox"))
		{
			
		}
		
		else if(BrowserName.equals("IE"))
		{
			
		}*/
		
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return driver;
		
		
	}	
	
	public static void quitBrowser(WebDriver driver)
	{
		driver.quit();
		
	}

}
