package com.hiphen.generic.baseclass;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.hiphen.generic.databaseutility.DataBaseUtility;
import com.hiphen.generic.fileutility.ExcelUtility;
import com.hiphen.generic.fileutility.FileUtility;
import com.hiphen.generic.objectrepository.UserLoginPage;
import com.hiphen.generic.webdriverutility.JavaUtility;
import com.hiphen.generic.webdriverutility.UtilityClassobject;
import com.hiphen.generic.webdriverutility.WebDriverUtility;


public class BaseClass {
	public FileUtility flib=new FileUtility();
	public ExcelUtility elib = new ExcelUtility();
	public DataBaseUtility dlib = new DataBaseUtility();
	public JavaUtility javalib = new JavaUtility();
	public WebDriverUtility wlib = new WebDriverUtility();
	public WebDriver driver = null;

	@BeforeSuite(groups = {"st","rt"})
	public void beforeSuite() throws SQLException {
		try {
		dlib.getConnection();
		}catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("coonected to db");

	}
  /* @Parameters("BROWSER")
	@BeforeClass(groups = {"st","rt"})
	public void launchBrowser(String browserxml) throws IOException {
		String browser = browserxml;
				//flib.getDataFromPropertiesFile("browser");

		if (browser.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equals("firefox")) {
			driver = new FirefoxDriver();
		} else if (browser.equals("edge")) {
			driver = new EdgeDriver();
		} else {
			driver = new ChromeDriver();
		}

	}*/
  
	@BeforeClass(groups = {"st","rt"})
  	public void launchBrowser() throws IOException {
  		String browser = flib.getDataFromPropertiesFile("browser");
  		if (browser.equals("chrome")) {
  			driver = new ChromeDriver();
  		} else if (browser.equals("firefox")) {
  			driver = new FirefoxDriver();
  		} else if (browser.equals("edge")) {
  			driver = new EdgeDriver();
  		} else {
  			driver = new ChromeDriver();
  		}
      UtilityClassobject.setDriver(driver);
  	}


	@BeforeMethod(groups = {"st","rt"})
	public void beforeMethod() throws IOException {
		wlib.implicitWait(driver);
		wlib.maximizeWindow(driver);
		String url = flib.getDataFromPropertiesFile("url");
		driver.get(url);
		System.out.println("login succesful");
	}

	@AfterMethod(groups = {"st","rt"})
	public void afterMethod() throws IOException {
		
		System.out.println("signed out succesfully");

	}

	@AfterClass(groups = {"st","rt"})
	public void afterClass() {
		driver.quit();
		System.out.println("closed browser succesfully");
	}
	
	@AfterSuite(groups = {"st","rt"})
	public void connclosed() throws SQLException
	{
		dlib.closeConnection();
		System.out.println("DB closed");
	}
	
/*
	@AfterSuite
	public void afterSuite() throws SQLException {
		dlib.closeConnection();
		System.out.println("disconnected from db");
	}
	@AfterSuite
	public void As()throws Throwable
	{
		dlib.closeConnection();
		System.out.println("disconnected from db");
	}
*/

}
