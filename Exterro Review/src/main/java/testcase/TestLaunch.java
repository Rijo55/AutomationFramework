package testcase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class TestLaunch 
{
	@Test
	public void iframe() throws Exception
	{
		
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://demo.guru99.com/test/delete_customer.php");
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		
			/*=========================Iframes================================*/		
		
	/*	Navigates to Outer Frame using ID
		 driver.switchTo().frame("iframeResult"); 
	
		Navigates to Inner Frame using Index
		 driver.switchTo().frame(0);
		 
		 driver.findElement(By.id("nav_search_btn")).click();
		 
		 Thread.sleep(5000);
		 driver.quit();*/
		 
		 
		/*		 ===============================Alerts====================================*/		 
		 
		driver.findElement(By.name("cusid")).sendKeys("123");
		driver.findElement(By.name("submit")).click();
		
		Alert alert = driver.switchTo().alert();
		alert.accept();
		
		String aMsg =driver.switchTo().alert().getText();
		String eMsg= "Customer Successfully Delete!";
		
		Assert.assertEquals(aMsg, eMsg);
		
		alert.accept();
		
	}
	
	
	
}

