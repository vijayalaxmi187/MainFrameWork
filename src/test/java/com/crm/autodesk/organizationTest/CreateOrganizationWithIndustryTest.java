package com.crm.autodesk.organizationTest;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.autodesk.ObjectRepository.CreateNewOrganizationPage;
import com.crm.autodesk.ObjectRepository.HomePage;
import com.crm.autodesk.ObjectRepository.OrganizationInformationPage;
import com.crm.autodesk.ObjectRepository.OrganizationPage;
import com.crm.autodeskgenericUtility.BaseClass;
import com.crm.autodeskgenericUtility.ExcelUtility;
import com.crm.autodeskgenericUtility.JavaUtility;


@Listeners(com.crm.autodeskgenericUtility.ListenerImplementationClass.class)
public class CreateOrganizationWithIndustryTest extends BaseClass {
	@Test(groups="regression testing")
	public void createOrganizationWithIndustry() throws Throwable {
		
		/*create object to libraries*/
		JavaUtility jLib = new JavaUtility();
		ExcelUtility eLib = new ExcelUtility();
		
		/*read common data from properties file*/
		/*get random data*/
		int randomNum=jLib.getRandomNumber();
	
		String OrgName = eLib.getDataFromExcel("Sheet1", 1, 2)+ randomNum;
		System.out.println(OrgName);
		String industryName =eLib.getDataFromExcel("Sheet1", 2, 3);
		System.out.println(industryName);
		
	    HomePage homePage = new HomePage(driver);
		homePage.clickOnOrganization();
		
		OrganizationPage organizationPage = new OrganizationPage(driver);
		organizationPage.clickOnImageIcon();
		
		CreateNewOrganizationPage createOrg = new CreateNewOrganizationPage(driver);
		createOrg.createIndustry(OrgName,industryName);
		
		OrganizationInformationPage orgInfoPage = new OrganizationInformationPage(driver);
        String actualOrgName = orgInfoPage.OrganizationInformationHeaderText();
		
		//verification of organization name
		//verification of industry type
		String actualIndustryName = createOrg.IndustryTypeHeaderText();
		
		Assert.assertEquals(actualIndustryName.contains(industryName),true);
		Assert.assertEquals(actualOrgName.contains(OrgName),true);
	}
}
		