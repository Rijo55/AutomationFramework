package com.ExterroReview.Utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class Config_DataProvider 
{	
	
	Properties prop;
	
	public Config_DataProvider()
	{
		File src = new File("./Properties/Config.properties");
		
		try 
		{
			FileInputStream fis=new FileInputStream(src);
			prop=new  Properties();
			prop.load(fis);
		} 
		
		catch (Exception e) 
		{
			System.out.println("Unable to load Config file" +e.getMessage());
		}
		
	}
	
	public String getBrowserName()
	{
		return prop.getProperty("BROWSER");
	}
	
	public String getProdURL_DRP7()
	{
		return prop.getProperty("PROD_URL_DRP7");
	}
	
	public String getUserName()
	{
		return prop.getProperty("USERNAME");
	}
	
	public String getPassword()
	{
		return prop.getProperty("PASSWORD");
	}
	
}
