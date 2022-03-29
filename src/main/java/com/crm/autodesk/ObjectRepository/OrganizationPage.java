package com.crm.autodesk.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * 
 * @author vijaylaxmi
 *
 */
public class OrganizationPage {
	public OrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
@FindBy(xpath="//img[@title='Create Organization...']")
private WebElement ImageIcon;

public WebElement getImageIcon() {
	return ImageIcon;
}
//business logic
/**
 * This method is used to click on create org image icon
 */
public void clickOnImageIcon() {
	ImageIcon.click();
}
}
