package com.crm.autodeskgenericUtility;

import java.io.File;
import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * 
 * @author Vijaylaxmi
 *
 */
public class WebDriverUtility {
	/**
	 * wait for page to load before identifying any synchronized element in DOM[HTML-Document]
	 * @param driver
	 */
	public void waitForPageToLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	}
	/**
	 * wait for the page to load before identifying any assynchronized[java scripts actions]elements in DOM[HTML-Document]
	 * @param driver
	 */
public void waitForPageToLoadForJSElement(WebDriver driver) {
	driver.manage().timeouts().setScriptTimeout(20,TimeUnit.SECONDS);
}
/**
 * used to wait for element to be clickable in GUI,&check for specific element for every 500 milli seconds
 * @param driver
 * @param actHeaderMsg
 */
public void waitForElementToBeClickable(WebDriver driver,WebElement element) {
	WebDriverWait wait=new WebDriverWait(driver,20);
	wait.until(ExpectedConditions.elementToBeClickable(element));
}
/**
 * used to switch to any window based on window title
 * @param driver
 * @param partialWindowTitle
 */
public void switchToWindow(WebDriver driver,String partialWindowTitle) {
	Set<String> set = driver.getWindowHandles();
	Iterator<String> it = set.iterator();
	while (it.hasNext()) {
		String wID = it.next();
		driver.switchTo().window(wID);
		String currentWindowTitle = driver.getTitle();	
		if(currentWindowTitle.contains(partialWindowTitle)) {
			break;
		}
		}
	}
/**
 * used to select the value from the dropDown based on value/option available in GUI
 * @param element
 * @param value
 */
public void select(WebElement element,String text) {
	Select sel = new Select(element);
	sel.selectByVisibleText(text);
}
/**
 * used to place mouse cursor on specified element
 * @param driver
 * @param element
 */
public void mouseOverOnElement(WebDriver driver,WebElement element) {
	Actions action = new Actions(driver);
	action.moveToElement(element).perform();
}
/**
 * used to right click on specified element
 * @param driver
 * @param element
 */
public void rightClickOnElement(WebDriver driver,WebElement element) {
	Actions action= new Actions(driver);
	action.contextClick(element).perform();
}
/*
 * avoid hidden division popup
 */
public void clickOnWebPageByValue(WebDriver driver,int xPixel,int yPixel)
 {
	Actions action= new Actions(driver);
	action.moveByOffset(xPixel, yPixel).click().perform();
	
}
/**
 * used to take screenshot
 * @throws Throwable 
 */
public String takesScreenshot(WebDriver driver,String screenshotName) throws Throwable {
	TakesScreenshot ts=(TakesScreenshot)driver;
	File source=ts.getScreenshotAs(OutputType.FILE);
	String timeStamp = LocalDateTime.now().toString().replace(":", "-");
    File destination=new File("./errorshot/"+timeStamp+screenshotName+".PNG");
    FileUtils.copyFile(source, destination);
    //source.renameTo(destination)
    return destination.getAbsolutePath();
	
}
}
