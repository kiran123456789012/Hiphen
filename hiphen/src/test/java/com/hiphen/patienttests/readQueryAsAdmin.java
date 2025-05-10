package com.hiphen.patienttests;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.hiphen.generic.baseclass.BaseClass;
import com.hiphen.generic.objectrepository.AdminDashboard;
import com.hiphen.generic.objectrepository.AdminLoginPage;
import com.hiphen.generic.objectrepository.ContactUs;
import com.hiphen.generic.objectrepository.HomePage;
import com.hiphen.generic.webdriverutility.UtilityClassobject;
@Listeners(com.hiphen.crm.generic.ilistener.ListenerImplementation.class)
public class readQueryAsAdmin extends BaseClass {
	@Test
	public void readQueryasAdmin() throws EncryptedDocumentException, IOException, InterruptedException
	{
	HomePage hp=new HomePage(driver);
	hp.getContactButton().click();
	 String username=elib.getDataFromExcelFile("Sheet1", 5, 2);
	 String email=elib.getDataFromExcelFile("Sheet1", 5, 3);
	 String phonenumber=elib.getDataFromExcelFile("Sheet1", 5, 4);
	 String description=elib.getDataFromExcelFile("Sheet1", 5, 5);
	 email=email+javalib.getRandomNumber()+"@gmail.com";
	 username=username+javalib.getRandomNumber();
	 System.out.println(username);
	 ContactUs cu=new ContactUs(driver);
	 cu.getNameTxtField().sendKeys(username);
	 cu.getEmailTxtField().sendKeys(email);
	 cu.getMobilenoTxtField().sendKeys(phonenumber);
	 cu.getDescriptionTxtField().sendKeys(description);
	 wlib.explicitWait(driver, cu.getSubmittButton());
	 wlib.scrollByAmount(driver, 0, 5000);
	 wlib.moveToElementAndClick(driver, cu.getSubmittButton());
	  try {
	 wlib.alertPresent(driver);
	 driver.switchTo().alert().accept();
	 }catch (Exception e) {
		System.out.println(e.getMessage());
	 }
	 hp.getHomeButton().click();
	 wlib.explicitWait(driver, hp.getAdminLoginLink());	 
	 wlib.scrollByAmount(driver, 0, 5000);
	 hp.getAdminLoginLink().click();
	 AdminLoginPage alp=new AdminLoginPage(driver);
	 String adminusername=elib.getDataFromExcelFile("Sheet1", 8, 2);
	 String adminpassword=elib.getDataFromExcelFile("Sheet1", 8, 3);
	 alp.getUsernameTxtField().sendKeys(adminusername);
	 alp.getPasswordTxtField().sendKeys(adminpassword);
	 alp.getLoginButton().click();
	 AdminDashboard ad=new AdminDashboard(driver);
	 ad.getContactUsQueryLink().click();
	 ad.getReadQueryLink().click();
	 System.out.println(username);
	 String resulted = driver.findElement(By.xpath("//td[text()='"+username+"']/ancestor::tr/descendant::td/div/a[@title='View Details']")).getText();
	System.out.println(resulted);
	boolean b=username.trim().contains(resulted);
	 Assert.assertTrue(b);
	 UtilityClassobject.getTest().log(Status.PASS, "passed");
}
}