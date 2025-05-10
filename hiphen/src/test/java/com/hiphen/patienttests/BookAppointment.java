package com.hiphen.patienttests;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.hiphen.generic.baseclass.BaseClass;
import com.hiphen.generic.baseclass.CommonUtilities;
import com.hiphen.generic.fileutility.ExcelUtility;
import com.hiphen.generic.fileutility.FileUtility;
import com.hiphen.generic.objectrepository.BookAppointmentPage;
import com.hiphen.generic.objectrepository.HomePage;
import com.hiphen.generic.objectrepository.UserDashboardPage;
import com.hiphen.generic.objectrepository.UserLoginPage;
import com.hiphen.generic.objectrepository.UserRegistrationPage;
import com.hiphen.generic.webdriverutility.JavaUtility;
import com.hiphen.generic.webdriverutility.UtilityClassobject;
import com.hiphen.generic.webdriverutility.WebDriverUtility;
@Listeners(com.hiphen.crm.generic.ilistener.ListenerImplementation.class)
public class BookAppointment extends BaseClass{
	@Test
	public void bookappointment() throws IOException, InterruptedException
	{
	
        String browser=flib.getDataFromPropertiesFile("browser");
		String url=flib.getDataFromPropertiesFile("url");
		String username=elib.getDataFromExcelFile("Sheet1", 1, 2);
	    String address=elib.getDataFromExcelFile("Sheet1", 1, 3);
	    String city=elib.getDataFromExcelFile("Sheet1", 1, 4);
	    String email=elib.getDataFromExcelFile("Sheet1", 1, 5);
	    String password=elib.getDataFromExcelFile("Sheet1", 1, 6);
		HomePage hp=new HomePage(driver);
		wlib.explicitWait(driver, hp.getUserLoginLink());
	    wlib.scrollByAmount(driver, 0, 5000);
	    WebElement loginlink = hp.getUserLoginLink();
	    loginlink.click();
	    username=username+javalib.getRandomNumber();
	    email=email+javalib.getRandomNumber()+"@gmail.com";
	    UserLoginPage ulp=new UserLoginPage(driver);
	    ulp.getUserRegistrationLink().click();
	    UserRegistrationPage urp=new UserRegistrationPage(driver);
	    urp.getUserFullNameTxtField().sendKeys(username);
	    urp.getUserAddressTxtField().sendKeys(address);
	    urp.getUserCityTxtField().sendKeys(city);
	    urp.getUserEmailTxtField().sendKeys(email);
	    urp.getUserPasswordTxtField().sendKeys(password);
	    urp.getUserPasswordAgainTxtField().sendKeys(password);
	    urp.getUserSubmittButton().click();
	    String confirmationtext = driver.switchTo().alert().getText();
	    System.out.println(confirmationtext);
	    driver.switchTo().alert().accept();
         wlib.explicitWait(driver, ulp.getUserLoginLink());
	     WebElement login = ulp.getUserLoginLink();
	     wlib.scrollByAmount(driver, 0, 4000);
	     login.click();
	     wlib.explicitWait(driver,ulp.getUserNameTextField() );
	     ulp.getUserNameTextField().sendKeys(email);
	     ulp.getUserPasswordTextField().sendKeys(password);
	     ulp.getUserLoginButton().click();
	     UserDashboardPage udp=new UserDashboardPage(driver);
	     udp.getBookAppointmentLink().click();
	     BookAppointmentPage bap=new BookAppointmentPage(driver);
	     wlib.selectbyVisibleText(bap.getDocSpecializationListbox(), "Dermatologist");
	     wlib.scrollByAmount(driver, 0, 1000);
	     bap.getDateTextField().click();
	     driver.findElement(By.xpath("//td[text()='10']")).click();
	     bap.getSubmittButton().click();
	     WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(10));
	     wait.until(ExpectedConditions.alertIsPresent());
	     String confirmationText = driver.switchTo().alert().getText();
	     driver.switchTo().alert().accept();
	     boolean b=!confirmationtext.isEmpty();
	     Assert.assertTrue(b);
	     UtilityClassobject.getTest().log(Status.PASS, "passed");
	    }
}