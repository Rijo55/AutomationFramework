package com.ExterroReview.Pages;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login_Page 
{
    WebDriver driver;
    
	public Login_Page(WebDriver ldriver)
    {
        this.driver=ldriver;
    }
	
	
	@FindBy(id= "username") WebElement Username;
	@FindBy(name= "password") WebElement Password;
	@FindBy(xpath="//span[text()='Sign in']") WebElement LoginButton;
		
	
	
	public void loginToExterro(String UserName, String PassWord) throws InterruptedException
	{
		
		try 
		{
			Thread.sleep(2000);
		} 
		catch (InterruptedException e) 
		{
			
		}
		
		Username.sendKeys(UserName);
		Password.sendKeys(PassWord);
		LoginButton.click();
		Thread.sleep(5000);
		
		
		String parent=driver.getWindowHandle();
		System.out.println("Parent ID is = "+parent);
		
		Set <String> s1=driver.getWindowHandles();
		
		int count=s1.size();
		System.out.println("Count is = "+count);
		
		/*Iterator <String> Itr= s1.iterator();
		
		while(Itr.hasNext())
		{
			String child=Itr.next();
		}*/
		
		for(String child:s1)
		{
			if(!parent.equals(child))
			{
				driver.switchTo().window(child);
				System.out.println(driver.getTitle());
				driver.findElement(By.xpath("//div[@class='ui-dialog-buttonset']//span[text()='Sign in']")).click();
				Thread.sleep(10000);
			}
		}
		
		driver.switchTo().window(parent);
		System.out.println("Parent Title is = "+driver.getTitle());
	}
}
