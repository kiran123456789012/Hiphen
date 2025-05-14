package com.hiphen.admin.tests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.hiphen.generic.baseclass.BaseClass;
import com.hiphen.generic.objectrepository.AddDoctorsSpecialization;
import com.hiphen.generic.objectrepository.AdminDashboard;
import com.hiphen.generic.objectrepository.AdminLoginPage;
import com.hiphen.generic.objectrepository.HomePage;
import com.hiphen.generic.webdriverutility.UtilityClassobject;
@Listeners(com.hiphen.crm.generic.ilistener.ListenerImplementation.class)
public class DeleteDocSpecializationTest extends BaseClass {
@Test
public void deletedocspecialization() throws EncryptedDocumentException, IOException, InterruptedException
{
	HomePage hp=new HomePage(driver);
	wlib.explicitWait(driver, hp.getAdminLoginLink());	 
	wlib.scrollByAmount(driver, 0, 5000);
	hp.getAdminLoginLink().click();
	String adminusername=elib.getDataFromExcelFile("Sheet1", 14, 2);
	String adminpassword=elib.getDataFromExcelFile("Sheet1", 14, 3);
	String specialization=elib.getDataFromExcelFile("Sheet1", 14, 4)+javalib.getRandomNumber();
	AdminLoginPage alp=new AdminLoginPage(driver);
	alp.getUsernameTxtField().sendKeys(adminusername);
	alp.getPasswordTxtField().sendKeys(adminpassword);
	alp.getLoginButton().click();
	AdminDashboard ad=new AdminDashboard(driver);
	ad.getDoctorsLink().click();
	ad.getAddSpecializationLink().click();
	AddDoctorsSpecialization ads=new AddDoctorsSpecialization(driver);
	ads.getSpecializationTxtField().sendKeys(specialization);
	ads.getSubmittButton().click();
    try {
	wlib.switchToAlertAndAccept(driver);
	}catch (Exception e) {
		// TODO: handle exception
	}
	WebElement edit = driver.findElement(By.xpath("//td[text()='"+specialization+"']/ancestor::tr/descendant::a[@class='btn btn-transparent btn-xs tooltips']"));
	wlib.scrollToBottomJs(driver);
	wlib.moveToElementAndClick(driver, edit);
	wlib.switchToAlertAndAccept(driver);
	String res=driver.findElement(By.xpath("//p[contains(text(),'data deleted !!')]")).getText();
	boolean b=res.isEmpty();
	Assert.assertFalse(b);
	 UtilityClassobject.getTest().log(Status.PASS, "passed");
}
}
