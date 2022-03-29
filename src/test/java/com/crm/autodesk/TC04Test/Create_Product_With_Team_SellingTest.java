package com.crm.autodesk.TC04Test;

//import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.autodesk.ObjectRepository.HomePage;
import com.crm.autodesk.ObjectRepository.QuickCreateProductPage;
import com.crm.autodesk.ObjectRepository.QuickCreateProductVerifyPage;
import com.crm.autodeskgenericUtility.BaseClass;
import com.crm.autodeskgenericUtility.ExcelUtility;
import com.crm.autodeskgenericUtility.JavaUtility;

//@Listeners(com.crm.autodeskgenericUtility.ListenerImplementationClass.class)
public class Create_Product_With_Team_SellingTest extends BaseClass {
	@Test(groups="integration testing")
public void createProductWithTeamSelling() throws Throwable {
	/*create object to libraries*/
	JavaUtility jLib = new JavaUtility();
	ExcelUtility eLib = new ExcelUtility();
	
	/*get random data*/
	int randomNum=jLib.getRandomNumber();
	
	//READ THE DATA FROM EXCEL SHEET
	String productName =eLib.getDataFromExcel("Sheet1", 1, 6);
	System.out.println(productName);
	String prodName = eLib.getDataFromExcel("Sheet1", 2, 5)+ randomNum;
	System.out.println(prodName);
	String handlerGroup = eLib.getDataFromExcel("Sheet1", 1, 7);
	System.out.println(handlerGroup);
	
	HomePage homePage = new HomePage(driver);
	homePage.clickQuickCreateLink(productName);
	
	QuickCreateProductPage quickProduct = new QuickCreateProductPage(driver);
	quickProduct.quickProductAdding(prodName,handlerGroup);
	
	QuickCreateProductVerifyPage boo = new QuickCreateProductVerifyPage(driver);
	String actual = boo.quickCreateProductVerify();
	
	//verification of organization name
			if(actual.contains(prodName)) {
				System.out.println("Sony product is created successfully::PASS");
			}else {
				System.out.println("Sony product is not created::FAIL");
			}
		
}
}
