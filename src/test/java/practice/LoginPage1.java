package practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.crm.autodesk.ObjectRepository.LoginPage;
import com.crm.autodeskgenericUtility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginPage1 {
	public static void main(String[] args) throws Throwable {
		
		WebDriverUtility wLib=new WebDriverUtility();
		String username="admin";
		String password="manager";
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		wLib.waitForPageToLoad(driver);
		driver.get("http://localhost:8888/");
		 
		 LoginPage loginPage = new LoginPage(driver);
		 loginPage.login(username, password);
		 
		
	}

}
