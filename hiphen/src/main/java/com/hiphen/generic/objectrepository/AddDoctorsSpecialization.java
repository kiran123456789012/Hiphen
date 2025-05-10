package com.hiphen.generic.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddDoctorsSpecialization {
@FindBy(xpath="//input[@name='doctorspecilization']")
private WebElement specializationTxtField;
@FindBy(xpath="//button[@name='submit']")
private WebElement submittButton;
public WebElement getSubmittButton() {
	return submittButton;
}

public WebElement getSpecializationTxtField() {
	return specializationTxtField;
}

public AddDoctorsSpecialization(WebDriver driver) 
{
	PageFactory.initElements( driver,this);
}
}
