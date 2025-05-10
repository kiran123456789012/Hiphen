package com.hiphen.generic.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddDoctorPage {
	@FindBy(xpath="//select[@name='Doctorspecialization']")
	private WebElement doctorSpecializationListbox;
	@FindBy(xpath="//input[@name='docname']")
	private WebElement doctorNameTxtField;
	@FindBy(xpath="//textarea[@name='clinicaddress']")
	private WebElement addressTxtField;
	@FindBy(xpath="//input[@name='docfees']")
	private WebElement consultancyTxtField;
	@FindBy(xpath="//input[@name='doccontact']")
	private WebElement contactTxtField;
	@FindBy(xpath="//input[@name='docemail']")
	private WebElement emailTxtField;
	@FindBy(xpath="//input[@name='npass']")
	private WebElement passwordTxtField;
	@FindBy(xpath="//input[@name='cfpass']")
	private WebElement confirmPasswordTxtField;
	//button[@name='submit']
	@FindBy(xpath="//button[@name='submit']")
	private WebElement submittButton;
	
	public WebElement getSubmittButton() {
		return submittButton;
	}

	public WebElement getConfirmPasswordTxtField() {
		return confirmPasswordTxtField;
	}

	//input[@name='cfpass']
	public WebElement getPasswordTxtField() {
		return passwordTxtField;
	}

	public WebElement getEmailTxtField() {
		return emailTxtField;
	}

	public WebElement getContactTxtField() {
		return contactTxtField;
	}

	public WebElement getAddressTxtField() {
		return addressTxtField;
	}

	public WebElement getConsultancyTxtField() {
		return consultancyTxtField;
	}

	public WebElement getDoctorNameTxtField() {
		return doctorNameTxtField;
	}

	public WebElement getDoctorSpecializationListbox() {
		return doctorSpecializationListbox;
	}

	public AddDoctorPage(WebDriver driver)
	{
		PageFactory.initElements( driver,this);
	}
}
