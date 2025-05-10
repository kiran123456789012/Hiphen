package com.hiphen.generic.webdriverutility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;
import java.util.logging.FileHandler;

import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
	public void implicitWait(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	public void explicitWait(WebDriver driver,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
		
	}
	public void switchToWindow(WebDriver driver,String partialUrl)
	{
		
	  Set<String> allwh = driver.getWindowHandles();
		for(String s:allwh)
		{
	    String text=driver.switchTo().window(s).getCurrentUrl();
	    if(text.contains(partialUrl))
		{
		 break;
		}
		
	}
	}
	
	public void switchToFrame(WebDriver driver,int index)
	{
		driver.switchTo().frame(index);
	}
	public void switchToFrame(WebDriver driver,String nameId)
	{
		driver.switchTo().frame(nameId);
	}
	public void switchToFrame(WebDriver driver,WebElement element)
	{
		driver.switchTo().frame(element);
	}
	
	public void switchToAlertAndAccept(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	public void switchToAlertAndDismiss(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	public String switchToAlertAndGetText(WebDriver driver)
	{
		String res = driver.switchTo().alert().getText();
		return res;
	}
	public void select(WebElement element,int index)
	{
		Select s=new Select(element);
		s.selectByIndex(index);
	}
	public void selectbyVisibleText(WebElement element,String visibleText)
	{
		Select s=new Select(element);
		s.selectByVisibleText(visibleText);
	}
	public void select(WebElement element,String value)
	{
		Select s=new Select(element);
		s.deselectByValue(value);
	}
	public void moveToElementAndClick(WebDriver driver,WebElement element)
	{
		Actions action=new Actions(driver);
		action.moveToElement(element).click().perform();
	}
	public void scrollByAmount(WebDriver driver,int x,int y)
	{
		Actions action=new Actions(driver);
		action.scrollByAmount(x, y).perform();
	}
	public void contextClick(WebDriver driver,WebElement element)
	{
		Actions action=new Actions(driver);
		action.contextClick().perform();
	}
	public void doubleClick(WebDriver driver,WebElement element)
	{
		Actions action=new Actions(driver);
		action.doubleClick(element);
	}
	public void dragAndDrop(WebDriver driver,WebElement source,WebElement destination)
	{
		Actions action=new Actions(driver);
		action.dragAndDrop(source, destination);
	}
	public void getScreenShot(WebDriver driver) throws IOException
	{
		TakesScreenshot screenShot=(TakesScreenshot) driver;
		File src = screenShot.getScreenshotAs(OutputType.FILE);
		File dest=new File("./ScreenShot/ss.png");
		org.openqa.selenium.io.FileHandler.copy(src, dest);
		
		
		
	}
	public void scrollByJs(WebDriver driver,int x,int y)
	{
		JavascriptExecutor j= (JavascriptExecutor)driver;
		j.executeScript("window.scrollBy(x,y)");
		
	}
	public void scrollToJs(WebDriver driver,int x,int y)
	{
		JavascriptExecutor j= (JavascriptExecutor)driver;
		j.executeScript("window.scrollTo(x,y)");
		
	}
	public void scrollToBottomJs(WebDriver driver)
	{
		JavascriptExecutor j= (JavascriptExecutor)driver;
	    j .executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}
	public void scrollToRightEndJs(WebDriver driver)
	{
		
		JavascriptExecutor j= (JavascriptExecutor)driver;
	    j .executeScript("window.scrollTo( document.body.scrollwidth,0)");
	}
	public void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	public void minimizeWindow(WebDriver driver)
	{
		driver.manage().window().minimize();
	}
	
	public void alertPresent(WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.alertIsPresent());
		
	}

}
