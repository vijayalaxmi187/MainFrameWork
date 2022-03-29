package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.crm.autodeskgenericUtility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoibiboOnlineHotelBooking {

	public static void main(String[] args) throws Throwable {
		WebDriverUtility wLib=new WebDriverUtility();
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		wLib.waitForPageToLoad(driver);
		driver.manage().window().maximize();
		driver.get("https://www.goibibo.com/hotels/");
		driver.findElement(By.xpath("//input[@name='CountryType']")).click();
	    driver.findElement(By.xpath("//input[@data-testid='home-autosuggest-input']")).sendKeys("Bengaluru");
	    Thread.sleep(5000);
	    wLib.clickOnWebPageByValue(driver, 298, 292);
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//div[text()='Check-in']")).click();
	    //driver.findElement(By.xpath("//span[@data-testid='date_31_2_2022']")).click();
	   // driver.findElement(By.xpath("//span[text()='March 2022']/following::span[text()='31']")).click();
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//span[text()='March 2022']/following::span[@data-testid='date_31_2_2022']")).click();
	    
	    driver.findElement(By.xpath("//input[@value='2 Adults | 0 Child | 1 Room ']")).click();
	}

}
