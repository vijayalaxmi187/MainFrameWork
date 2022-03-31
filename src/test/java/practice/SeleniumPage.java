package practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.crm.autodeskgenericUtility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumPage {

	public static void main(String[] args) throws Throwable {
		WebDriverUtility wLib=new WebDriverUtility();
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		wLib.waitForPageToLoad(driver);
		driver.manage().window().maximize();
		driver.get("https://www.selenium.dev/");
		List<WebElement> names = driver.findElements(By.xpath("//li[@class='nav-item mr-4 mb-2 mb-lg-0']"));
		for (WebElement ele : names) {
			System.out.println(ele.getText());
			
		}
	}
}