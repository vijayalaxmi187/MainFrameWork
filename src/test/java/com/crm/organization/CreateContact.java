package com.crm.organization;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContact {

	public static void main(String[] args) throws Throwable {
		
		FileInputStream fin = new FileInputStream(".\\src\\main\\resources\\commonData\\credentials.properties");
		Properties pro_obj=new Properties();
		pro_obj.load(fin);
		String browser = pro_obj.getProperty("browser");
		String url = pro_obj.getProperty("url");
		String username = pro_obj.getProperty("username");
		String password = pro_obj.getProperty("password");
		System.out.println(browser);
		System.out.println(url);
		System.out.println(username);
		System.out.println(password);
		
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\testdata3.xlsx");
		Workbook workbook = WorkbookFactory.create(fis);
        Sheet sheet = workbook.getSheet("Sheet1");
        
        int rowCount = sheet.getPhysicalNumberOfRows();
        int colCount = sheet.getRow(0).getPhysicalNumberOfCells();
        System.out.println("Number of rows====="   +rowCount);
        System.out.println("Number of columns===="   +colCount);
        
        for (int i = 0; i <=rowCount-1; i++) {
        	for (int j = 0; j <=colCount-1; j++) {
        	System.out.print(sheet.getRow(i).getCell(j).getStringCellValue()+ "\t");
        	}
        	System.out.println();
        }
		System.out.println("============================");
		String lastnameData = sheet.getRow(1).getCell(0).getStringCellValue();
		System.out.println(lastnameData);
	
		
		WebDriver driver=null;
		
		if(browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			System.out.println("launched browser is"+ browser);
}else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			System.out.println("launched browser is"+browser);
}else {
	System.out.println("==it supports only two browsers==");
}
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
		//click on contacts link
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		driver.findElement(By.name("lastname")).sendKeys(lastnameData);
		
		Random r = new Random();
		int randomNum=r.nextInt(1000);
		lastnameData = lastnameData+ randomNum;
		  
		
		//WebElement industryList = driver.findElement(By.name("industry"));
		//Select s1=new Select(industryList);
		//s1.selectByValue(industryData);
		
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		Thread.sleep(5000);
		WebElement web = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		
		Actions action=new Actions(driver);
		action.moveToElement(web).perform();
		
		driver.findElement(By.linkText("Sign Out")).click();
		driver.quit();
}
	

}
