package com.hiphen.generic.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminLoginPage {
	@FindBy(name="username")
	private WebElement usernameTxtField;
	@FindBy(name="password")
	private WebElement passwordTxtField;
	@FindBy(name="submit")
	private WebElement loginButton;
	public WebElement getUsernameTxtField() {
		return usernameTxtField;
	}
	public WebElement getPasswordTxtField() {
		return passwordTxtField;
	}
	public WebElement getLoginButton() {
		return loginButton;
	}
	public AdminLoginPage(WebDriver driver)
	{
		PageFactory.initElements( driver,this);
	}


}
