package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SampleSeleniumTest {
	public static void main(String[] args) {
		FirefoxOptions option=new FirefoxOptions();
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver=new FirefoxDriver(option);
		driver.get("http://localhost:8888/");
		//step1:login to app
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("manager");
		driver.findElement(By.id("submitButton")).click();
		
	}
}
