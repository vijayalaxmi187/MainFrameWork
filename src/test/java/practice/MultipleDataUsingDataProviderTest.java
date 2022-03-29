package practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MultipleDataUsingDataProviderTest {
	//to execute same script with multiple data
	//use @DataProvider annotation==>it will provide data to @Test annotated method
	@Test(dataProvider = "getdata")
	public void multipledata(String name,String company,String emailID,String empID) {
		System.out.println(name);
		System.out.println(company);
		System.out.println(emailID);
		System.out.println(empID);
		System.out.println("===============");
		
	}
@DataProvider()
public Object[][]  getdata() {
	Object[][] objArray= new Object[2][4];
	objArray[0][0]="vijju";
	objArray[0][1]="tyss banglore";
	objArray[0][2]="vij@gmail.com";
	objArray[0][3]="tyss001";
	
	objArray[1][0]="vijay";
	objArray[1][1]="tyss mysore";
	objArray[1][2]="avina@gmail.com";
	objArray[1][3]="tyss003";
	
	return objArray;
}
}
	
	
	
			
	
	
	


