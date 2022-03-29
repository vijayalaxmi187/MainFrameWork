package practice;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Tester1 {
	public static void main(String[] args) throws IOException, Exception {
		Random ran=new Random();
		int rannum = ran.nextInt(1000);
		
		String orgName= "Vijju" + "_"+rannum;
		ExcelLibrary lib = new ExcelLibrary();
		
		String usernameData = lib.getData("Sheet1", 1, 0);
		String passwordData = lib.getData("Sheet1", 1, 1);
		
		//FirefoxOptions option=new FirefoxOptions();
		//WebDriverManager.firefoxdriver().setup();
		//WebDriver driver=new FirefoxDriver(option);
		WebDriver driver=new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("http://localhost:8888/");
		
		//step1:login to app
		driver.findElement(By.name("user_name")).sendKeys(usernameData);
		driver.findElement(By.name("user_password")).sendKeys(passwordData);
		driver.findElement(By.id("submitButton")).click();
		
		//step2:navigate to organization 
		driver.findElement(By.linkText("Organizations")).click();
		
		//step3:navigate to create organization page
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		
		//step4:create a new organization
		driver.findElement(By.name("accountname")).sendKeys(orgName);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//step5:verify
		String actHeaderMsg = driver.findElement(By.className("dvHeaderText")).getText();
		if(actHeaderMsg.contains(orgName))
		{
			System.out.println(orgName+ "is verified==PASS");
		}else {
			System.out.println(orgName+ "is not verified==FAIL");
		}
		//step6:logout
		WebElement wb = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions action=new Actions(driver);
		action.moveToElement(wb).perform();
		driver.findElement(By.linkText("Sign Out")).click();
		driver.quit();
		
		
	}
}
