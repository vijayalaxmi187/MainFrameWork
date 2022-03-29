package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.crm.autodeskgenericUtility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CalenderScenario {
	public static void main(String[] args) {
		
		String monthAndYear = "May 2022";
		String date = "9";
		
		WebDriverUtility wLib = new WebDriverUtility();
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
	    
	    wLib.waitForPageToLoad(driver);
	    driver.get("https://www.makemytrip.com");
	    //driver.findElement(By.xpath("//p[@data-cy='departureDate']"));
	    
	    wLib.clickOnWebPageByValue(driver, 10, 10);
	    
	    driver.findElement(By.xpath("//span[@class='langCardClose']")).click();
	    driver.findElement(By.xpath("//p[@data-cy='departureDate']")).click();
	    //driver.findElement(By.xpath("//div[text()='March 2022']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='5']")).click();
	    String path = "//div[text()='"+monthAndYear+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='"+date+"']";
		
		for(;;) {
			try {
				driver.findElement(By.xpath(path)).click();
				break;
			} catch (Exception e) {
			driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
			}
			System.out.println(monthAndYear);
			System.out.println(date);
		}
		//driver.quit();
	}

}
