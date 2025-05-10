package com.hiphen.generic.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactUs {
@FindBy(name="fullname")
private WebElement nameTxtField;
@FindBy(name="emailid")
private WebElement emailTxtField;
@FindBy(name="mobileno")
private WebElement mobilenoTxtField;
public WebElement getNameTxtField() {
	return nameTxtField;
}
public WebElement getEmailTxtField() {
	return emailTxtField;
}
public WebElement getMobilenoTxtField() {
	return mobilenoTxtField;
}
public WebElement getDescriptionTxtField() {
	return descriptionTxtField;
}
public WebElement getSubmittButton() {
	return submittButton;
}
@FindBy(xpath="//textarea[@name='description']")
private WebElement descriptionTxtField;
@FindBy(xpath="//input[@name='submit']")
private WebElement submittButton;
public ContactUs(WebDriver driver)
{
	PageFactory.initElements(driver,this);
}
}
