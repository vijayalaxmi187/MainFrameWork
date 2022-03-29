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
public class ContactInfoVerifyPage {
	public ContactInfoVerifyPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement headerText;

	public WebElement getHeaderText() {
		return headerText;
	}
	/**
	 * This method is used to verify the contact info header text
	 * @return
	 */
public String verifyContHeaderText() {
	return headerText.getText();
}
}
