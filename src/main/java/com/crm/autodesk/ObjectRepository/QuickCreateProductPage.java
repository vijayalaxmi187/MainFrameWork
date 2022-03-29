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
public class QuickCreateProductPage extends WebDriverUtility {
	public QuickCreateProductPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@name='productname']")
	private WebElement productNameTextField;
	
	@FindBy(xpath="//input[@name='assigntype' and @value='T']")
	private WebElement handlerGroupRadioButton;
	
	@FindBy(xpath="//input[@type='submit']")
	private WebElement saveButton;
	
	@FindBy(xpath="//select[@name='assigned_group_id']")
	private WebElement dropDownTextField;

	public WebElement getDropDownTextField() {
		return dropDownTextField;
	}

	public WebElement getProductNameTextField() {
		return productNameTextField;
	}

	public WebElement getHandlerGroupRadioButton() {
		return handlerGroupRadioButton;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	/**
	 * This method is used to create product name and to save
	 * @param productName
	 */
	public void quickProductAdding(String productName,String handlerGroup) {
		productNameTextField.sendKeys(productName);
		handlerGroupRadioButton.click();
		select(dropDownTextField,handlerGroup);
		dropDownTextField.click();
		saveButton.click();
	}
	

}
