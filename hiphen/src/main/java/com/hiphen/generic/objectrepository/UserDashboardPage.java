package com.hiphen.generic.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserDashboardPage {
	public UserDashboardPage(WebDriver driver)
	{
		PageFactory.initElements( driver,this);
	}
@FindBy(xpath="//a[contains(text(),'Update Profile')]")
private WebElement updateProfileLink;
@FindBy(xpath="//select[@name='gender']")
private WebElement genderDropdown;
@FindBy(xpath="//button[@name='submit']")
private WebElement updateButton;
@FindBy(xpath="//span[text()=' Book Appointment ']")
private WebElement bookAppointmentLink;
public WebElement getBookAppointmentLink() {
	return bookAppointmentLink;
}

public WebElement getUpdateButton() {
	return updateButton;
}

public WebElement getGenderDropdown() {
	return genderDropdown;
}

public WebElement getUpdateProfileLink() {
	return updateProfileLink;
	
}
}
