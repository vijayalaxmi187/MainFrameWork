package practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.crm.autodesk.ObjectRepository.HomePage;
import com.crm.autodesk.ObjectRepository.LoginPage;
import com.crm.autodeskgenericUtility.ExcelUtility;
import com.crm.autodeskgenericUtility.FileUtility;
import com.crm.autodeskgenericUtility.JavaUtility;
import com.crm.autodeskgenericUtility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CompatibilityCodeBrowser {
	
	public WebDriver driver=null;
	//object creation
	public FileUtility fUtil =new FileUtility();
	public ExcelUtility eUtil=new ExcelUtility();
	public JavaUtility jUtil=new JavaUtility();
	public WebDriverUtility wUtil=new WebDriverUtility();
	
	@BeforeSuite(groups= {"smoke testing","regression testing","integration testing"})
	public void beforeSuite() {
		System.out.println("data base connection");
	}
	
	@BeforeTest(groups= {"smoke testing","regression testing","integration testing"})
	public void beforeTest() {
		System.out.println("execute script in parallel mode");
	}
	//for distributed parallel execution
	@Parameters("browser")
    @BeforeClass(groups= {"smoke testing","regression testing","integration testing"})
    //Browser launching
    public void beforeClass(String browserName) throws Throwable {
    //	String browserName=fUtil.getPropertyKeyValue("browser");
    	String url=fUtil.getPropertyKeyValue("url");
    	if(browserName.equals("chrome")) {
    		WebDriverManager.chromedriver().setup();
    		 driver=new ChromeDriver();
    	}else if(browserName.equals("firefox")) {
    		WebDriverManager.firefoxdriver().setup();
    		driver=new FirefoxDriver();
    	}else {
    		throw new Exception("browser is not compatible");
    		
    	}
    	driver.get(url);
    	driver.manage().window().maximize();
    	wUtil.waitForPageToLoad(driver);
    }
    @BeforeMethod(groups= {"smoke testing","regression testing","integration testing"})
    public void beforeMethod() throws Throwable {
    	String userName=fUtil.getPropertyKeyValue("username");
    	String password=fUtil.getPropertyKeyValue("password");
    	LoginPage loginPage = new LoginPage(driver);
    	loginPage.login(userName, password);
    }
    @AfterMethod(groups= {"smoke testing","regression testing","integration testing"})
    public void afterMethod() {
    HomePage homePage = new HomePage(driver);
    homePage.logout(driver);
    }
    @AfterClass(groups= {"smoke testing","regression testing","integration testing"})
    public void afterClass() {
    	driver.quit();
    }
    @AfterTest(groups= {"smoke testing","regression testing","integration testing"})
    public void afterTest() {
    	System.out.println("close parallel mode execution");
    }
    @AfterSuite(groups= {"smoke testing","regression testing","integration testing"})
    public void afterSuite() {
    	System.out.println("close the data base connection");
    }
    	
    
}



