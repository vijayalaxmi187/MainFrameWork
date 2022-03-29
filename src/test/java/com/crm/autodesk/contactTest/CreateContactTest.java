package com.crm.autodesk.contactTest;

import org.testng.Assert;
//import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.autodesk.ObjectRepository.CreateContactPage;
import com.crm.autodesk.ObjectRepository.CreateNewContactPage;
import com.crm.autodesk.ObjectRepository.HomePage;
import com.crm.autodeskgenericUtility.BaseClass;
import com.crm.autodeskgenericUtility.ExcelUtility;
import com.crm.autodeskgenericUtility.JavaUtility;
/**
 * 
 * @author vijayalaxmi
 *
 */
//@Listeners(com.crm.autodeskgenericUtility.ListenerImplementationClass.class)
public class CreateContactTest extends BaseClass {
    @Test(groups="smoke testing")
	public void createContact() throws Throwable {
		/*create object to libraries*/
		JavaUtility jLib = new JavaUtility();
		ExcelUtility eLib = new ExcelUtility();
		
		/*read common data from properties file*/
		
		/*get random data*/
		int randomNum=jLib.getRandomNumber();
		
		//read test data from Ecel file
		String lastNameData=eLib.getDataFromExcel("Sheet1", 2, 2)+ randomNum;

		
		HomePage homePage = new HomePage(driver);
		homePage.clickOnContacts();
		
		CreateContactPage createContact = new CreateContactPage(driver);
		createContact.clickOnPlusIcon();
		Assert.fail();
		
		CreateNewContactPage createnew = new CreateNewContactPage(driver);
		createnew.createContact(lastNameData);
		
		String actualLastNameData = createnew.verifyLastName();
		
		/*verify the contacts creation*/
		
	Assert.assertEquals(actualLastNameData.contains(lastNameData),true);

	}
}
		