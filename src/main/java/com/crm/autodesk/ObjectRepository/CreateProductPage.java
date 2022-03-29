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
public class CreateProductPage {
	public CreateProductPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//img[@title='Create Product...']")
	private WebElement plusImageIcon;

	public WebElement getPlusImageIcon() {
		return plusImageIcon;
	}
	
	//business logic
	/**
	 * This method is used to click on plus create product image
	 */
	public void clickOnPlusImageIcon() {
		plusImageIcon.click();
	}

}
