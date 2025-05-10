package com.hiphen.generic.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditDocSpecizlization {
	
@FindBy(xpath="//input[@name='doctorspecilization']")
private WebElement editDocSpecialization;
@FindBy(xpath="//button[@name='submit']")
private WebElement updateButton;
public EditDocSpecizlization(WebDriver driver)
{
	PageFactory.initElements( driver,this);
}
public WebElement getEditDocSpecialization() {
	return editDocSpecialization;
}
public WebElement getUpdateButton() {
	return updateButton;
}
}
