package com.hiphen.generic.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookAppointmentPage {
	public BookAppointmentPage (WebDriver driver)
	{
		PageFactory.initElements( driver,this);
	}
	@FindBy(xpath="//select[@name='Doctorspecialization']")
	private WebElement docSpecializationListbox;
	@FindBy(xpath="//select[@name='doctor']")
	private WebElement docNameListbox;
	@FindBy(xpath="//input[@class='form-control datepicker']")
	private WebElement dateTextField;
	@FindBy(xpath="//button[@name='submit']")
	private WebElement submittButton;
	public WebElement getSubmittButton() {
		return submittButton;
	}
	public WebElement getDateTextField() {
		return dateTextField;
	}
	public WebElement getDocNameListbox() {
		return docNameListbox;
	}
	public WebElement getDocSpecializationListbox() {
		return docSpecializationListbox;
	}
	
}
