package practice;

import java.time.LocalDateTime;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.crm.autodeskgenericUtility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CalenderScenarioWithTomorrowsDate {
	public static void main(String[] args) {
		
		WebDriverUtility wLib=new WebDriverUtility();
		
		LocalDateTime dateAndTime=LocalDateTime.now().plusDays(1);
		String month = dateAndTime.getMonth().toString();
		int date = dateAndTime.getDayOfMonth();
		int year = dateAndTime.getYear();
		String actualMonth = month.substring(0,1)+month.substring(1).toLowerCase();
		String monthAndYear = actualMonth+" "+year;
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		wLib.waitForPageToLoad(driver);
		driver.manage().window().maximize();
		driver.get("https://www.makemytrip.com/");
		wLib.clickOnWebPageByValue(driver, 10, 10);
		
		driver.findElement(By.xpath("//span[@class='langCardClose']")).click();
	    driver.findElement(By.xpath("//p[@data-cy='departureDate']")).click();
	    //driver.findElement(By.xpath("//div[text()='March 2022']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='5']")).click();
	    String path = "//div[text()='"+monthAndYear+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='"+date+"']";
		driver.findElement(By.xpath(path)).click();
		
	}
	}

				
		
		
	
	



