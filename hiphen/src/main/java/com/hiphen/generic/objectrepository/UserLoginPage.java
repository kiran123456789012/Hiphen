package com.hiphen.generic.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserLoginPage {
	@FindBy(xpath="//a[@ href='registration.php']")
	private WebElement userRegistrationLink;
	@FindBy(xpath="//a[@href='user-login.php']")
	private WebElement userLoginLink;
	@FindBy(name="username")
	private WebElement userNameTextField;
	@FindBy(name="password")
	private WebElement userPasswordTextField;
	@FindBy(xpath="//button[@type='submit']")
	private WebElement userLoginButton;
	

	public WebElement getUserNameTextField() {
		return userNameTextField;
	}
	public WebElement getUserPasswordTextField() {
		return userPasswordTextField;
	}
	public WebElement getUserLoginButton() {
		return userLoginButton;
	}
	public WebElement getUserLoginLink() {
		return userLoginLink;
	}
	public WebElement getUserRegistrationLink() {
		return userRegistrationLink;
	}
	public UserLoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

}
