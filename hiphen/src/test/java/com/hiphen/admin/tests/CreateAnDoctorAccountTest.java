package com.hiphen.admin.tests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.junit.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.hiphen.generic.baseclass.BaseClass;
import com.hiphen.generic.objectrepository.AddDoctorPage;
import com.hiphen.generic.objectrepository.AdminDashboard;
import com.hiphen.generic.objectrepository.AdminLoginPage;
import com.hiphen.generic.objectrepository.HomePage;
import com.hiphen.generic.webdriverutility.UtilityClassobject;
@Listeners(com.hiphen.crm.generic.ilistener.ListenerImplementation.class)
public class CreateAnDoctorAccountTest extends BaseClass {
	@Test
	public void addDoctorByAdmin() throws EncryptedDocumentException, IOException, InterruptedException {
	HomePage hp=new HomePage(driver);
	 wlib.explicitWait(driver, hp.getAdminLoginLink());	 
	 wlib.scrollByAmount(driver, 0, 5000);
	 hp.getAdminLoginLink().click();
	 AdminLoginPage alp=new AdminLoginPage(driver);
	 String adminusername=elib.getDataFromExcelFile("Sheet1", 11, 2);
	 String adminpassword=elib.getDataFromExcelFile("Sheet1", 11, 3);
	 String doctorSpecialization=elib.getDataFromExcelFile("Sheet1", 11, 4);
	 String doctorname=elib.getDataFromExcelFile("Sheet1", 11, 5)+javalib.getRandomNumber();
	 String adress=elib.getDataFromExcelFile("Sheet1", 11, 6);
	 String fees=elib.getDataFromExcelFile("Sheet1", 11, 7);
	 String contactno=elib.getDataFromExcelFile("Sheet1", 11, 8);
	 String email=elib.getDataFromExcelFile("Sheet1", 11, 9)+javalib.getRandomNumber()+"@gmail.com";
	 String password=elib.getDataFromExcelFile("Sheet1", 11, 10);
	 alp.getUsernameTxtField().sendKeys(adminusername);
	 alp.getPasswordTxtField().sendKeys(adminpassword);
	 alp.getLoginButton().click();
	 AdminDashboard ad=new AdminDashboard(driver);
	 ad.getDoctorsLink().click();
	 ad.getAddDoctorsLink().click();
	 AddDoctorPage adp=new AddDoctorPage(driver);
	 wlib.selectbyVisibleText(adp.getDoctorSpecializationListbox(), doctorSpecialization);
	 adp.getDoctorNameTxtField().sendKeys(doctorname);
	 adp.getAddressTxtField().sendKeys(adress);
	 adp.getConsultancyTxtField().sendKeys(fees);
	 adp.getContactTxtField().sendKeys(contactno);
	 adp.getEmailTxtField().sendKeys(email);
	 adp.getPasswordTxtField().sendKeys(password);
	 adp.getConfirmPasswordTxtField().sendKeys(password);
	 adp.getSubmittButton().click();
	 try {
	String res= wlib.switchToAlertAndGetText(driver);
	System.out.println(res);
	boolean b=res.isEmpty();
	Assert.assertFalse(b);
	wlib.switchToAlertAndAccept(driver);
	 }catch (Exception e) {
	}
	 UtilityClassobject.getTest().log(Status.PASS, "passed");
}
}
