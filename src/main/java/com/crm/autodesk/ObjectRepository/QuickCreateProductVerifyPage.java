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
public class QuickCreateProductVerifyPage {
	public QuickCreateProductVerifyPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//span[@class='lvtHeaderText']")
	private WebElement headerTextVerify;
	
	public WebElement getHeaderTextVerify() {
		return headerTextVerify;
	}
	/**
	 * This method is used to verify Quick create product name
	 * @return
	 */
public String quickCreateProductVerify() {
	return headerTextVerify.getText();
}
}
