package com.hiphen.generic.baseclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CommonUtilities {
	WebDriver driver;
	public WebDriver launchBrowser(String browser)
	{
		if(browser.equals("chrome"))
		{
			 driver=new ChromeDriver();
		}
		else if(browser.equals("firefox"))
		{
			 driver=new FirefoxDriver();
		}
		else if(browser.equals("edge"))
		{
			driver=new EdgeDriver();
		}
		else 
		{
			driver=new ChromeDriver();
		}
	
     return driver;
}
}
