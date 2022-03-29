package com.crm.organization;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
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

public class CreateCampaign {

public static void main(String[] args) throws Throwable {
			
			//FileInputStream fin = new FileInputStream(".\\src\\main\\resources\\commonData\\credentials.properties");
	        FileInputStream fin = new FileInputStream(".\\src\\test\\resources\\credentials.properties");
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
			
			//FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\testdata5.xlsx");
			FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\testdata.xlsx");
			Workbook workbook = WorkbookFactory.create(fis);
	        Sheet sheet = workbook.getSheet("Sheet1");
	        
	        int rowCount = sheet.getPhysicalNumberOfRows();
	        int colCount = sheet.getRow(0).getPhysicalNumberOfCells();
	        System.out.println("Number of rows====="   +rowCount);
	        System.out.println("Number of columns===="   +colCount);
	        
	        /*for (int i = 0; i <=rowCount-1; i++) {
	        	for (int j = 0; j <=colCount-1; j++) {
	        	System.out.print(sheet.getRow(i).getCell(j).getStringCellValue()+ "\t");
	        	}
	        	System.out.println();
	        }*/
			System.out.println("============================");
			String campName = sheet.getRow(1).getCell(0).getStringCellValue();
			System.out.println(campName);
		
			Random r = new Random();
			int randomNum=r.nextInt(1000);
			campName = campName+ randomNum;
			
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
			
			WebElement web = driver.findElement(By.linkText("More"));
			WebElement web2 = driver.findElement(By.name("Campaigns"));
			Actions action=new Actions(driver);
			action.moveToElement(web).perform();
			action.moveToElement(web2).click().perform();
			
			driver.findElement(By.xpath("//img[@title='Create Campaign...']")).click();
			driver.findElement(By.name("campaignname")).sendKeys(campName);
			//String parentWindow = driver.getWindowHandle();
			driver.findElement(By.xpath("//img[@title='Select']")).click();
			
			Set<String> allWindowIds = driver.getWindowHandles();
			List<String> windowId = new ArrayList<String>(allWindowIds);
			for (String windowIds : allWindowIds) {
				System.out.println(windowIds);
				
			}
			 driver.switchTo().window(windowId.get(1));
			String product = sheet.getRow(0).getCell(1).getStringCellValue();
			//System.out.println(product);
			driver.findElement(By.id("search_txt")).sendKeys(product);
			driver.findElement(By.name("search")).click();
			
			List<WebElement> listofProductName = driver.findElements(By.xpath("//td/a"));
			for (WebElement productName : listofProductName) {
				System.out.println(productName.getText());
				if(productName.getText().equalsIgnoreCase(product)) {
					productName.click();
					break;
				}
				
			}
			
			// for (WebElement productsNames : listofProductName) {
				// System.out.println(productsNames.getText());
				
			}
			
			
			

	}


