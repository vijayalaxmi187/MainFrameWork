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
public class CreateNewOrganizationPage extends WebDriverUtility {
	//declaration
	public CreateNewOrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
@FindBy(xpath="//input[@name='accountname']")
private WebElement orgNameTextField;

@FindBy(xpath="//select[@name='industry']")
private WebElement industryTextField;

@FindBy(xpath="//input[@title='Save [Alt+S]']")
private WebElement Savebutton;

@FindBy(id="dtlview_Industry")
private WebElement IndustryHeaderText;

//getters
public WebElement getOrgNameTextField() {
	return orgNameTextField;
}

public WebElement getIndustryHeaderText() {
	return IndustryHeaderText;
}

public WebElement getIndustryTextField() {
	return industryTextField;
}

public WebElement getSavebutton() {
	return Savebutton;
}
//business logic
/**
 * This method used to enter org name
 * @param orgName
 */
public void createOrganization(String orgName) {
	orgNameTextField.sendKeys(orgName);
	Savebutton.click();
}
/**
 * This method is used to enter org name and choose industry TYpe
 */
public void createIndustry(String orgName ,String industryName) {
	orgNameTextField.sendKeys(orgName);
	industryTextField.click();
	select(industryTextField,industryName);
	Savebutton.click();
	
}
/**
 * This method is used to verify industry type header text
 * @return
 */
public String IndustryTypeHeaderText() {
	return IndustryHeaderText.getText();
}
}
