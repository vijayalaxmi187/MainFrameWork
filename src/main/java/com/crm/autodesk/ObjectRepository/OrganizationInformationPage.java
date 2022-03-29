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
public class OrganizationInformationPage {
	//initialization
	public OrganizationInformationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement OrganizationInformationHeader;
	
	//getter
	public WebElement OrganizationInformationHeader() {
		return OrganizationInformationHeader;
	}
//business logic
	/**
	 * This method is used to verify orgname header text
	 * @return
	 */
	public String OrganizationInformationHeaderText() {
		return OrganizationInformationHeader.getText();
		
	}
}
