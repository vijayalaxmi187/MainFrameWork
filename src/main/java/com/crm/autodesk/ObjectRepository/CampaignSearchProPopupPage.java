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
public class CampaignSearchProPopupPage extends WebDriverUtility{
	public CampaignSearchProPopupPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="search_txt")
	private WebElement searchTextField;
	
	@FindBy(name="search")
	private WebElement searchButton;
	

	public WebElement getSearchTextField() {
		return searchTextField;
	}

	public WebElement getSearchButton() {
		return searchButton;
	}
	public void campaignPopup(WebDriver driver,String productName) {
		searchTextField.sendKeys(productName);
		searchButton.click();
		
		//switchToWindow(driver, "Campaigns");
		
		
	}
	

}
