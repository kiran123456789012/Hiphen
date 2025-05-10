package com.hiphen.patienttests;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.hiphen.generic.baseclass.BaseClass;
import com.hiphen.generic.objectrepository.ContactUs;
import com.hiphen.generic.objectrepository.HomePage;
import com.hiphen.generic.webdriverutility.UtilityClassobject;
@Listeners(com.hiphen.crm.generic.ilistener.ListenerImplementation.class)
public class submitQuery extends BaseClass{
	@Test
	public void submittQueryyy() throws EncryptedDocumentException, IOException, InterruptedException
	{
	HomePage hp=new HomePage(driver);
	 hp.getContactButton().click();
	 String username=elib.getDataFromExcelFile("Sheet1", 5, 2);
	 String email=elib.getDataFromExcelFile("Sheet1", 5, 3);
	 String phonenumber=elib.getDataFromExcelFile("Sheet1", 5, 4);
	 String description=elib.getDataFromExcelFile("Sheet1", 5, 5);
	 email=email+javalib.getRandomNumber()+"@gmail.com";
	 username=username+javalib.getRandomNumber();
	 ContactUs cu=new ContactUs(driver);
	 cu.getNameTxtField().sendKeys(username);
	 cu.getEmailTxtField().sendKeys(email);
	 cu.getMobilenoTxtField().sendKeys(phonenumber);
	 cu.getDescriptionTxtField().sendKeys(description);
	 wlib.explicitWait(driver, cu.getSubmittButton());
	 wlib.scrollByAmount(driver, 0, 5000);
	 wlib.moveToElementAndClick(driver, cu.getSubmittButton());
	// Thread.sleep(3000);
	 WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
	 wait.until(ExpectedConditions.alertIsPresent());
	String res = driver.switchTo().alert().getText();
	System.out.println(res);
	boolean b=!res.isEmpty();
    Assert.assertTrue(b);
	driver.switchTo().alert().accept();
	UtilityClassobject.getTest().log(Status.PASS, "passed");
	 
}
}
