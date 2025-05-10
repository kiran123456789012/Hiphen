package com.hiphen.generic.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminDashboard {
@FindBy(xpath=" //span[text()=' Conatctus Queries ']")
private WebElement contactUsQueryLink;
@FindBy(xpath=" //span[text()=' Unread Query ']")
private WebElement readQueryLink;
@FindBy(xpath=" //span[text()=' Doctors ']")
private WebElement doctorsLink;
@FindBy(xpath="//span[text()=' Add Doctor']")
private WebElement addDoctorsLink;
public WebElement getAddSpecializationLink() {
	return addSpecializationLink;
}
@FindBy(xpath="//span[text()=' Doctor Specialization ']")
private WebElement addSpecializationLink;

public WebElement getAddDoctorsLink() {
	return addDoctorsLink;
}
public WebElement getDoctorsLink() {
	return doctorsLink;
}

public WebElement getReadQueryLink() {
	return readQueryLink;
}
public WebElement getContactUsQueryLink() {
	return contactUsQueryLink;
}
public AdminDashboard(WebDriver driver)
{
	PageFactory.initElements( driver,this);
}
}
