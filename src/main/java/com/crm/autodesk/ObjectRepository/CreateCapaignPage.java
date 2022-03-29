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
public class CreateCapaignPage {
	public CreateCapaignPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//img[@title='Create Campaign...']")
	private WebElement plusImageIcon;

	public WebElement getPlusImageIcon() {
		return plusImageIcon;
	}
/**
 * This method is used to create new Campaign
 */
public void clickOnPlusIcon() {
	plusImageIcon.click();
}
}
