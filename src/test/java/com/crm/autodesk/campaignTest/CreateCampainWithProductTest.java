package com.crm.autodesk.campaignTest;

import org.openqa.selenium.By;
import org.testng.Assert;
//import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.autodesk.ObjectRepository.CampaignSearchProPopupPage;
import com.crm.autodesk.ObjectRepository.CompaignLinkPage;
import com.crm.autodesk.ObjectRepository.CreateCapaignPage;
import com.crm.autodesk.ObjectRepository.CreateNewCampaignPage;
import com.crm.autodesk.ObjectRepository.CreateNewProductPage;
import com.crm.autodesk.ObjectRepository.CreateProductPage;
import com.crm.autodesk.ObjectRepository.HomePage;
import com.crm.autodeskgenericUtility.BaseClass;
import com.crm.autodeskgenericUtility.ExcelUtility;
import com.crm.autodeskgenericUtility.JavaUtility;

//@Listeners(com.crm.autodeskgenericUtility.ListenerImplementationClass.class)
public class CreateCampainWithProductTest extends BaseClass {
	@Test
public void createCampainWithProduct() throws Throwable
{
	/*create object to libraries*/
	JavaUtility jLib = new JavaUtility();
	ExcelUtility eLib = new ExcelUtility();
	
	/*get randomData*/
	int randomNum=jLib.getRandomNumber();
	/*read test data from Ecel file*/
		String campName = eLib.getDataFromExcel("Sheet1", 1, 4)+ randomNum;
		String productName=eLib.getDataFromExcel("Sheet1", 2, 2)+ randomNum;
       // String product = eLib.getDataFromExcel("Sheet1", 0, 1);
	
	HomePage homePage = new HomePage(driver);
	homePage.clickOnProducts();
	
	
	CreateProductPage createProduct = new CreateProductPage(driver);
	createProduct.clickOnPlusImageIcon();
	
	CreateNewProductPage newProduct = new CreateNewProductPage(driver);
	newProduct.createProduct(productName);
	
	String actualProduct = newProduct.productText();
	System.out.println(actualProduct);

//verify the contacts creation
	
	Assert.assertEquals(actualProduct.contains(productName),true); 
	//Campaign Creation with product
	
	CompaignLinkPage campaign = new CompaignLinkPage(driver);
	CreateCapaignPage newCamp = new CreateCapaignPage(driver);
	
	CreateNewCampaignPage campInfo = new CreateNewCampaignPage(driver);
	
	CampaignSearchProPopupPage popUp = new CampaignSearchProPopupPage(driver);
	
	
homePage.clickOnMoreLink();
campaign.campaignpageLink();
newCamp.clickOnPlusIcon();
campInfo.campaignInfo(driver, campName,"Products");

popUp.campaignPopup(driver, productName);
driver.findElement(By.xpath("//a[text()='"+productName+"']")).click();
campInfo.saveCamp(driver, "Campaigns");
String actualName = campInfo.campHeaderVerify();

//verify the campain creation


Assert.assertEquals(actualName.contains(campName),true);

String actualProductName = campInfo.productTextInCampPage(driver, productName);


Assert.assertEquals(actualProductName.contains(productName),true);
}

}

	


	
			