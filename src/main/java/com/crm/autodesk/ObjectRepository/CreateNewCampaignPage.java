package com.crm.autodesk.ObjectRepository;

import org.openqa.selenium.By;
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
public class CreateNewCampaignPage extends WebDriverUtility{
	public CreateNewCampaignPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
@FindBy(name="campaignname")
private WebElement campaignNameTextField;

@FindBy(xpath="//img[@src='themes/softed/images/select.gif']")
private WebElement productPlusIcon;

@FindBy(xpath="//input[@title='Save [Alt+S]']")
private WebElement saveButton;

@FindBy(xpath="//span[@class='dvHeaderText']")
private WebElement campHeaderText;


public WebElement getSaveButton() {
	return saveButton;
}

public WebElement getCampHeaderText() {
	return campHeaderText;
}

//public WebElement getCampaignNameTextField() {
	//return campaignNameTextField;
//}
/**
 * This method is used to enter(create) campaign info and to save
 * @param campaignName
 */
public void campaignInfo(WebDriver driver, String campName,String partailtitle) {
	campaignNameTextField.sendKeys(campName);
	productPlusIcon.click();
	switchToWindow(driver, partailtitle);
	//saveButton.click();
}
public String campHeaderVerify() {
	return campHeaderText.getText();
}
public void saveCamp(WebDriver driver,String Campaigns) {
	switchToWindow(driver, "Campaigns");
	saveButton.click();

}

public String productTextInCampPage(WebDriver driver,String productName) {
	String productText = driver.findElement(By.xpath("//span[@id='dtlview_Product']/child::a[text()='"+productName+"']")).getText();

	return productText;


}

}
