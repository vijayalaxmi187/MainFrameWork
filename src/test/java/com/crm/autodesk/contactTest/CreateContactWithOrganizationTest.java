package com.crm.autodesk.contactTest;

import org.openqa.selenium.By;
import org.testng.Assert;
//import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.autodesk.ObjectRepository.ContactInfoVerifyPage;
import com.crm.autodesk.ObjectRepository.CreateContactPage;
import com.crm.autodesk.ObjectRepository.CreateNewContactPage;
import com.crm.autodesk.ObjectRepository.CreateNewOrganizationPage;
import com.crm.autodesk.ObjectRepository.CreateOrgPopUpPage;
import com.crm.autodesk.ObjectRepository.HomePage;
import com.crm.autodesk.ObjectRepository.OrganizationInformationPage;
import com.crm.autodesk.ObjectRepository.OrganizationPage;
import com.crm.autodeskgenericUtility.BaseClass;
import com.crm.autodeskgenericUtility.ExcelUtility;
import com.crm.autodeskgenericUtility.JavaUtility;
//@Listeners(com.crm.autodeskgenericUtility.ListenerImplementationClass.class)
public class CreateContactWithOrganizationTest extends BaseClass {
  @Test(groups="smoke testing")
	public void createContactWithOrganization() throws Throwable {
		/*create object to libraries*/
		JavaUtility jLib = new JavaUtility();
		ExcelUtility eLib = new ExcelUtility();
		
		/*read common data from properties file*/
		
		/*get random data*/
		int randomNum=jLib.getRandomNumber();
		
		//read test data from Ecel file
	String orgName = eLib.getDataFromExcel("Sheet1", 2, 1)+ randomNum;
	String lastNameData=eLib.getDataFromExcel("Sheet1", 2, 2)+ randomNum;
	
		/*launch the Browser*/
		HomePage homePage = new HomePage(driver);
		homePage.clickOnOrganization();
		
		OrganizationPage organizationPage = new OrganizationPage(driver);
		organizationPage.clickOnImageIcon();
		
		CreateNewOrganizationPage createOrg = new CreateNewOrganizationPage(driver);
		createOrg.createOrganization(orgName);
		
		OrganizationInformationPage orgInfoPage = new OrganizationInformationPage(driver);
	    String actualOrgName = orgInfoPage.OrganizationInformationHeaderText();
		
		//verification of organization name
	    Assert.assertEquals(actualOrgName.contains(orgName),true);
		
		homePage.clickOnContacts();
		
		CreateContactPage createContact = new CreateContactPage(driver);
		createContact.clickOnPlusIcon();
		
		CreateNewContactPage createnew = new CreateNewContactPage(driver);
		createnew.createContactWithOrg(lastNameData);
		
		CreateOrgPopUpPage popUp = new CreateOrgPopUpPage(driver);
		popUp.orgNamePopup(orgName, driver, "Accounts");
		
		//driver.findElement(By.xpath("//a[text()='+TestYantra2062+']")).click();
		driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
		
		popUp.switchBackTo(driver, "Contacts");
		createnew.clickSaveButton();
		  
		String actualLastNameData = createnew.verifyLastName();
		
		/*verify the lastname of contact creation*/
		Assert.assertEquals(actualLastNameData.contains(lastNameData),true);
		
		ContactInfoVerifyPage infoVerify = new ContactInfoVerifyPage(driver);
		String actualContName = infoVerify.verifyContHeaderText();
		
		/*verify the contact info with org name*/
		Assert.assertEquals(actualContName.contains(lastNameData),true);
	
	}
}