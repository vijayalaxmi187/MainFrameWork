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
public class CompaignLinkPage {
public CompaignLinkPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}
@FindBy(name="Campaigns")
private WebElement campaignLink;

public WebElement getCampaignLink() {
	return campaignLink;
}
/**
 * This method is used to click on campaign link
 */
public void campaignpageLink() {
	campaignLink.click();
}
}
