package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.autodeskgenericUtility.ExcelUtility;
import com.crm.autodeskgenericUtility.FileUtility;
import com.crm.autodeskgenericUtility.JavaUtility;
import com.crm.autodeskgenericUtility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContactWithDate {

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

		
		
		//read test data from Ecel file
		//String orgName = eLib.getDataFromExcel("Sheet1", 2, 1)+ randomNum;
		//String lastNameData=eLib.getDataFromExcel("Sheet1", 2, 2)+ randomNum;
		String lastnameData=eLib.getDataFromExcel("Sheet1", 1, 0)+ randomNum;
		
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
		
		/*webdriverutility*/
		wLib.waitForPageToLoad(driver);
		
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		//click on contacts link
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		driver.findElement(By.name("lastname")).sendKeys(lastnameData);
		 WebElement date2 = driver.findElement(By.xpath("//input[@id='jscal_field_support_start_date']"));
		 date2.clear();
		 String systemDate = jLib.getSystemDateTime();
		 date2.sendKeys(systemDate);
		 driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//WebElement actualDate = driver.findElement(By.id("//span[@id='dtlview_Support Start Date']"));
		String actualDate = driver.findElement(By.id("dtlview_Support Start Date")).getText();
		System.out.println(systemDate+ "===System Date");
		System.out.println(actualDate+ "===Actual Date");
		if(actualDate.equals(systemDate)) {
			System.out.println(systemDate + "= is Correct::PASS");
		}else {
			System.out.println(systemDate + "=is not correct::FAIL");
		}
		

		wLib.mouseOverOnElement(driver, driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")));
		driver.findElement(By.linkText("Sign Out")).click();
		driver.quit();
}
	

}

	
