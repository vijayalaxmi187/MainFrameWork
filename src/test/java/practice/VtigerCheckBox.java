package practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.crm.autodeskgenericUtility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VtigerCheckBox {
	public static void main(String[] args) {
		WebDriverUtility wLib=new WebDriverUtility();
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		wLib.waitForPageToLoad(driver);
		driver.manage().window().maximize();
		driver.get("http://localhost:8888/");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("manager");
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Organizations")).click();
		List<WebElement> checkboxes = driver.findElements(By.name("selected_id"));
		for (WebElement ele : checkboxes) {
			ele.click();
			
			
		}
	}

}
