package practice;

import java.time.LocalDateTime;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.crm.autodeskgenericUtility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FlightMakeMyTripEndToEnd {
public static void main(String[] args) {
	
	WebDriverUtility wLib=new WebDriverUtility();
	
	LocalDateTime dateAndTime=LocalDateTime.now().plusDays(2);
	String month = dateAndTime.getMonth().toString();
	int date = dateAndTime.getDayOfMonth();
	int year = dateAndTime.getYear();
	
	String actualMonth = month.substring(0,1)+month.substring(1).toLowerCase();
	String monthAndYear = actualMonth+" "+year;
	String srcAddress = "Pune";
	String destAddress = "Mumbai";
	
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	wLib.waitForPageToLoad(driver);
	driver.manage().window().maximize();
	driver.get("https://www.makemytrip.com/");
	
	wLib.clickOnWebPageByValue(driver, 10, 10);
	
	driver.findElement(By.xpath("//span[@class='langCardClose']")).click();
   
   // System.out.println(monthAndYear+" "+date);
    
    driver.findElement(By.xpath("//span[text()='From']")).click();
    driver.findElement(By.xpath("//p[contains(@class,'blackText') and contains(text(),'"+srcAddress+"')]")).click();
    driver.findElement(By.xpath("//span[text()='To']")).click();
    driver.findElement(By.xpath("//p[contains(@class,'blackText') and contains(text(),'"+destAddress+"')]")).click();
    
    driver.findElement(By.xpath("//p[@data-cy='departureDate']")).click();
    String path = "//div[text()='"+monthAndYear+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='"+date+"']";
    driver.findElement(By.xpath(path)).click();
    
    driver.findElement(By.xpath("//a[text()='Search']")).click();
    
    wLib.clickOnWebPageByValue(driver, 10, 20);
    
    //driver.findElement(By.xpath("bgProperties icon20 overlayCrossIcon")).click();
    WebElement flightElement = driver.findElement(By.xpath("//p[@class='font24 blackFont whiteText appendBottom20 journey-title']"));
    wLib.waitForElementToBeClickable(driver, flightElement);
     List<WebElement> listOfFlight = driver.findElements(By.xpath("//span[@class='boldFont blackText airlineName']"));
     for (WebElement ele : listOfFlight) {
    	 System.out.println(ele.getText());
		//driver.quit();
	}
}
}
