package com.hiphen.generic.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	@FindBy(xpath = "//a[@ href='hms/user-login.php']")
	private WebElement userLoginLink;
	public WebElement getAdminLoginLink() {
		return adminLoginLink;
	}

	@FindBy(xpath = "//a[@href='hms/admin']")
	private WebElement adminLoginLink;
	@FindBy(xpath="//div[@class='top-nav']/ul/li/a[text()='contact']")
	private WebElement contactButton;
	@FindBy(xpath="//div[@class='top-nav']/ul/li/a[text()='Home']")
	private WebElement homeButton;

	public WebElement getContactButton() {
		return contactButton;
	}

	public WebElement getHomeButton() {
		return homeButton;
	}

	public WebElement getUserLoginLink() {
		return userLoginLink;
	}

	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

}
