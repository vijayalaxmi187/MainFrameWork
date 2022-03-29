package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.crm.autodeskgenericUtility.ExcelUtility;
import com.crm.autodeskgenericUtility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ClearTripCalenderScenario {
	public static void main(String[] args) throws Throwable {
		
		ExcelUtility eLib=new ExcelUtility();
		WebDriverUtility wLib=new WebDriverUtility();
		String month = eLib.getDataFromExcel("Sheet1",1,0);
		String date = eLib.getDataFromExcel("Sheet1",1,1);
		String year = eLib.getDataFromExcel("Sheet1",1,2);
		String formatDate = month+" "+date+" "+year;
		System.out.println(formatDate);
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.cleartrip.com/");
		wLib.waitForPageToLoad(driver);
		driver.findElement(By.xpath("//div[text()='Sat, Mar 5']")).click();
		while(true) {
			try {
				driver.findElement(By.xpath("//div[@class='DayPicker-Months']/descendant::div[@aria-label='"+formatDate+"']")).click();
				break;
			}catch(Exception e) {
				driver.findElement(By.cssSelector("svg[data-testid='rightArrow']")).click();
				
			}
		}
	
	}

}
