package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import com.crm.autodeskgenericUtility.ExcelUtility;
import com.crm.autodeskgenericUtility.FileUtility;
import com.crm.autodeskgenericUtility.JavaUtility;
import com.crm.autodeskgenericUtility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrganizationWithIndustryTest {
	
	public static void main(String[] args) throws Throwable {
		
		/*create object to libraries*/
		JavaUtility jLib = new JavaUtility();
		FileUtility fLib = new FileUtility();
		WebDriverUtility wLib = new WebDriverUtility();
		ExcelUtility eLib = new ExcelUtility();
		
		/*read common data from properties file*/
		String BROWSER = fLib.getPropertyKeyValue("browser");
		String URL = fLib.getPropertyKeyValue("url");
		String USERNAME = fLib.getPropertyKeyValue("username");
		String PASSWORD= fLib.getPropertyKeyValue("password");
		
		/*get random data*/
		int randomNum=jLib.getRandomNumber();
	
		String orgName = eLib.getDataFromExcel("Sheet1", 1, 2)+ randomNum;
		System.out.println(orgName);
		String industryName =eLib.getDataFromExcel("Sheet1", 2, 3);
		System.out.println(industryName);
		//String type =eLib.getDataFromExcel("Sheet1", 1, 3);
		//System.out.println(type);
		
		WebDriver driver=null;
		
		if(BROWSER.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			System.out.println("launched browser is"+ BROWSER);
}else if (BROWSER.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			System.out.println("launched browser is"+BROWSER);
}else {
	System.out.println("==it supports only two browsers==");
}
		driver.manage().window().maximize();
		driver.get(URL);
		
		/*WebDriverUtility*/
		wLib.waitForPageToLoad(driver);
		
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		//click on organization link
		driver.findElement(By.xpath("//td[@class='tabUnSelected']//a[text()='Organizations']")).click();
		//click on + image
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		//enter orgname
		
				
		driver.findElement(By.name("accountname")).sendKeys(orgName);
		
		Select select = new Select(driver.findElement(By.name("industry")));
		select.selectByVisibleText(industryName);
		
		//Select select1 = new Select(driver.findElement(By.name("accounttype")));
		//select1.selectByVisibleText(type);
		
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		
		 String actHeaderMsg = driver.findElement(By.className("dvHeaderText")).getText();
			if(actHeaderMsg.contains(orgName))
			{
				System.out.println(orgName+ " orgName is verified==PASS");
			}else {
				System.out.println(orgName+ " orgName is not verified==FAIL");
			}
		
		String actualIndustryName = driver.findElement(By.id("dtlview_Industry")).getText();
		 System.out.println(actualIndustryName);
		/*verify the contacts creation*/
		if(actualIndustryName.contains(industryName)) {
			System.out.println(industryName+" industryName is verified:PASS");
		}else {
			System.out.println(industryName+"industryName is not verified:Fail");
		}
		/*String type1 = driver.findElement(By.id("dtlview_Type")).getText();
		 System.out.println(type1);
		verify the contacts creation
		if(type1.contains(type)) {
			System.out.println(type1+" type1 is verified:PASS");
		}else {
			System.out.println(type1+" type1 is not verified:Fail");
		}*/
		/*from webdriver utility*/
		wLib.mouseOverOnElement(driver, driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")));
		
		driver.findElement(By.linkText("Sign Out")).click();
		driver.quit();
}
	

}
