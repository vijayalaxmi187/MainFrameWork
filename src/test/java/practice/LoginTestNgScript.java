package practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTestNgScript {
	@Test(dataProvider = "getData")
public void ContactsData(String name,String phoneno) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:8888");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("manager");
		driver.findElement(By.id("submitButton")).click();
		//click on contacts link
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		driver.findElement(By.name("lastname")).sendKeys("vijju");
		driver.findElement(By.id("mobile")).sendKeys("0123455");
		Actions action=new Actions(driver);
		WebElement web = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		
		action.moveToElement(web).perform();
		
		driver.findElement(By.linkText("Sign Out")).click();
		
	
}
	@DataProvider()
	public Object[][] getData() {
		Object[][] objArray= new Object[2][2];
		objArray[0][0]="vijju";
		objArray[0][1]="tyss banglore";
		
		
		objArray[1][0]="Akash";
		objArray[1][1]="mysore";
		
		return objArray;
	
}
}