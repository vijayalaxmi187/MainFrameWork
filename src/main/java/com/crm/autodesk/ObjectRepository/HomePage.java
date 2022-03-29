package com.crm.autodesk.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodeskgenericUtility.WebDriverUtility;

/*
 * This is HomePage object repository
 * @author vijaylaxmi
 */
public class HomePage extends WebDriverUtility {
	/*initialization of web element*/
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
/*declaration of web elements*/
	@FindBy(linkText="Organizations")
	private WebElement organizationLink;
	
	@FindBy(linkText="Leads")
	private WebElement LeadsLink;
	
	@FindBy(linkText="Contacts")
	private WebElement ContactsLink;
	
	@FindBy(linkText="Products")
	private WebElement ProductsLink;
	
	@FindBy(xpath="//select[@id='qccombo']")
	private WebElement QuickCreateLink;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement signOutIconImage;
	
	@FindBy(linkText="Sign Out")
	private WebElement signOutLink;
	
	@FindBy(linkText="More")
	private WebElement moreLink;
	
	/*getters method*/

	public WebElement getOrganizationLink() {
		return organizationLink;
	}

	public WebElement getMoreLink() {
		return moreLink;
	}

	public WebElement getQuickCreateLink() {
		return QuickCreateLink;
	}

	public WebElement getLeadsLink() {
		return LeadsLink;
	}

	public WebElement getContactsLink() {
		return ContactsLink;
	}
	
	public WebElement getSignOutIconImage() {
		return signOutIconImage;
	}

	public WebElement getProductsLink() {
		return ProductsLink;
	}

	/**
	 * This method will click
	 * @return
	 */
	public WebElement getSignOutLink() {
		return signOutLink;
	}
	/*business logic*/
	/**
	 * This method will click on organization link
	 */
	public void clickOnOrganization() {
		organizationLink.click();
	}
	/**
	 * This method is used to click on product link
	 */
	
	public void clickOnProducts() {
		ProductsLink.click();
	}
	/**
	 * This method is used to click on contacts link
	 */
	public void clickOnContacts() {
		ContactsLink.click();
	}
	 /**
	 * This method is used to logout from home page
	 * @param driver
	 */
	public void logout(WebDriver driver) {
		mouseOverOnElement(driver,signOutIconImage);
		signOutLink.click();
	}
	/**
	 * This method is used to click on more link
	 */
	public void clickOnMoreLink() {
		moreLink.click();
	}
	/**
	 * This method is used to click on QuickCreateLink
	 */
	public void clickQuickCreateLink(String productName) {
		select(QuickCreateLink,productName);
		QuickCreateLink.click();
	
	}
}
