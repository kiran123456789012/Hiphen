package com.hiphen.generic.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserRegistrationPage {
	@FindBy(name="full_name")
	private WebElement userFullNameTxtField;
	@FindBy(name="address")
	private WebElement userAddressTxtField;
	@FindBy(name="city")
	private WebElement userCityTxtField;
	public WebElement getUserPasswordAgainTxtField() {
		return userPasswordAgainTxtField;
	}

	@FindBy(name="email")
	private WebElement userEmailTxtField;
	@FindBy(name="password")
	private WebElement userPasswordTxtField;
	@FindBy(name="password_again")
	private WebElement userPasswordAgainTxtField;
	
	@FindBy(id="submit")
	private WebElement userSubmittButton;
	
	public WebElement getUserFullNameTxtField() {
		return userFullNameTxtField;
	}
	public WebElement getUserSubmittButton() {
		return userSubmittButton;
	}
	public WebElement getUserAddressTxtField() {
		return userAddressTxtField;
	}
	public WebElement getUserCityTxtField() {
		return userCityTxtField;
	}
	public WebElement getUserEmailTxtField() {
		return userEmailTxtField;
	}
	public WebElement getUserPasswordTxtField() {
		return userPasswordTxtField;
	}
	
	public UserRegistrationPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	
}
