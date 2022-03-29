package com.crm.autodesk.TC04Test;

import org.testng.Assert;
//import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.autodesk.ObjectRepository.CreateNewProductPage;
import com.crm.autodesk.ObjectRepository.CreateProductPage;
import com.crm.autodesk.ObjectRepository.HomePage;
import com.crm.autodeskgenericUtility.BaseClass;
import com.crm.autodeskgenericUtility.ExcelUtility;
import com.crm.autodeskgenericUtility.JavaUtility;

//@Listeners(com.crm.autodeskgenericUtility.ListenerImplementationClass.class)
public class Create_Product_By_ProductlinkTest extends BaseClass {
  @Test(groups="integration testing")
	public void createProductByProduct() throws Throwable {
		/*create object to libraries*/
		JavaUtility jLib = new JavaUtility();
		ExcelUtility eLib = new ExcelUtility();

		/*get random data*/
		int randomNum=jLib.getRandomNumber();
		
		//read test data from Ecel file
		String productName = eLib.getDataFromExcel("Sheet1", 1, 5)+ randomNum;
		System.out.println(productName);

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
}
		
}	
		

