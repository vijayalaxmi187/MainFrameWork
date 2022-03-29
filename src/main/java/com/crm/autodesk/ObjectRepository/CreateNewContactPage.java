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
public class CreateNewContactPage {
	public CreateNewContactPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//input[@name='lastname']")
	private WebElement lastNameTextField;
	
	@FindBy(xpath="//img[@src='themes/softed/images/select.gif']")
	private WebElement orgNamePlusIcon;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveButton;
	
	@FindBy(id="dtlview_Last Name")
	private WebElement verifyContact;
	
	
	//getters

	public WebElement getLastNameTextField() {
		return lastNameTextField;
	}

	public WebElement getOrgNamePlusIcon() {
		return orgNamePlusIcon;
	}

	public WebElement getVerifyContact() {
		return verifyContact;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	/**
	 * This method is used to enter last name in the text field and save
	 * @param lastName
	 */
	public void createContact(String lastName ) {
		lastNameTextField.sendKeys(lastName);
		saveButton.click();
	}
	/**
	 * This method is used to create contact with click on org name plus icon
	 * @param lastName
	 */
	public void createContactWithOrg(String lastName ) {
		lastNameTextField.sendKeys(lastName);
		orgNamePlusIcon.click();
	}
	/**
	 * This method is used to verify the last name added to contact
	 * @return
	 */
	public String verifyLastName() {
		return verifyContact.getText();
	}
	/**
	 * This method is used to save created contact
	 */
    public void clickSaveButton() {
    	saveButton.click();
    }
}
