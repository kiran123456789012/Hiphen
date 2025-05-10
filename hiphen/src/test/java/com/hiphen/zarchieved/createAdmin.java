package com.hiphen.zarchieved;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.hiphen.generic.baseclass.CommonUtilities;
import com.hiphen.generic.fileutility.FileUtility;
import com.hiphen.generic.webdriverutility.JavaUtility;
import com.hiphen.generic.webdriverutility.WebDriverUtility;

public class createAdmin {
	@Test
	public void createAdminAccount() throws InterruptedException, IOException
	{

	FileUtility flib=new FileUtility();
	CommonUtilities clib=new CommonUtilities();
	WebDriverUtility wlib=new WebDriverUtility();
	String browser=flib.getDataFromPropertiesFile("browser");
	String url=flib.getDataFromPropertiesFile("url");
	WebDriver driver = clib.launchBrowser(browser);
	wlib.implicitWait(driver);
	driver.get(url);
	Thread.sleep(2000);
	wlib.maximizeWindow(driver);
    WebElement loginlink = driver.findElement(By.xpath("//a[@href='hms/admin']"));
    Actions action=new Actions(driver);
    action.scrollByAmount(0, 5000).perform();
    loginlink.click();
    String username="rogesh";
    String email="rogesh@123";
    JavaUtility jlib=new JavaUtility();
    username=username+jlib.getRandomNumber();
    email=email+jlib.getRandomNumber();
    driver.findElement(By.xpath("//a[@ href='registration.php'] 	")).click();
    driver.findElement(By.name("full_name")).sendKeys(username);
    driver.findElement(By.name("address")).sendKeys("navi mumbai,gandhinagar,#559");
    driver.findElement(By.name("city")).sendKeys("mumbai");
    driver.findElement(By.name("email")).sendKeys(email);
    driver.findElement(By.name("password")).sendKeys("rogesh@123");
    driver.findElement(By.name("password_again")).sendKeys("rogesh@123",Keys.ENTER);
}

}
