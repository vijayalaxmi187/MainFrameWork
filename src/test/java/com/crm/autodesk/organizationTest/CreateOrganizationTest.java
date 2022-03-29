package com.crm.autodesk.organizationTest;
import org.testng.Assert;
//import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.autodesk.ObjectRepository.CreateNewOrganizationPage;
import com.crm.autodesk.ObjectRepository.HomePage;
import com.crm.autodesk.ObjectRepository.OrganizationInformationPage;
import com.crm.autodesk.ObjectRepository.OrganizationPage;
import com.crm.autodeskgenericUtility.BaseClass;
import com.crm.autodeskgenericUtility.ExcelUtility;
import com.crm.autodeskgenericUtility.JavaUtility;
//@Listeners(com.crm.autodeskgenericUtility.ListenerImplementationClass.class)
public class CreateOrganizationTest extends BaseClass {
	@Test(groups="regression testing")
	public void createOrganization() throws Throwable {
		
	/*Create object to libraries*/
	JavaUtility jLib = new JavaUtility();
	ExcelUtility eLib = new ExcelUtility();
		
    /*get random data*/
    int randomNum=jLib.getRandomNumber();

    //read test data from Ecel file
	String orgName = eLib.getDataFromExcel("Sheet1", 2, 1)+ randomNum;
	System.out.println("organization name is "+orgName);

	//login to vtiger
	/*read common data from properties file*/
	//run time Polymorphism	
	/*Create Object of LoginPage From ObjectRepository*/
	
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
	
	}
}
	