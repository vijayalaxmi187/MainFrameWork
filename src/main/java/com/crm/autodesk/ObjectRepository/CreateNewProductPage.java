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
public class CreateNewProductPage {
	public CreateNewProductPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@name='productname']")
	private WebElement productNameTextField;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveButton;
	
	@FindBy(id="dtlview_Product Name")
	private WebElement verifyProduct;
	
	public WebElement getVerifyProduct() {
		return verifyProduct;
	}

	public WebElement getProductNameTextField() {
		return productNameTextField;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	//business logic
	/**
	 * This method is used to enter product name in text field and to save
	 * @param productName
	 */
	public void createProduct(String productName) {
		productNameTextField.sendKeys(productName);
		saveButton.click();
		
	}
	/**
	 * This method is used to get actual product
	 * @return
	 */
public String productText() {
	return verifyProduct.getText();
			}
}
