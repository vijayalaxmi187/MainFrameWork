package com.crm.autodesk.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodeskgenericUtility.WebDriverUtility;
/**
 * 
 * @author vijaylaxmi
 *
 */
public class CreateOrgPopUpPage extends WebDriverUtility {
	public CreateOrgPopUpPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="search_txt")
	private WebElement orgNameTextField;
	
	@FindBy(xpath="//input[@name='search']")
	private WebElement searchNowTextField;

	public WebElement getOrgNameTextField() {
		return orgNameTextField;
	}

	public WebElement getSearchNowTextField() {
		return searchNowTextField;
	}
	/**
	 * This method is used to enter orgname and to search and switch to window
	 * @param orgName
	 * @param driver
	 * @param Accounts
	 */
	public void orgNamePopup(String orgName,WebDriver driver,String Accounts ) {
		switchToWindow(driver, "Accounts");
		orgNameTextField.sendKeys(orgName);
		searchNowTextField.click();
	}
	/**
	 * This method is used to switch back window to contacts
	 * @param driver
	 * @param Contacts
	 */
	public void switchBackTo(WebDriver driver,String Contacts ) {
		switchToWindow(driver, Contacts);
	}

}
