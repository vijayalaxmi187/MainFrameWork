package practice;

import org.testng.annotations.Test;

public class UserInformationTest {
	
@Test(groups="smoke testing")
public void createInfo() {
	System.out.println("create user information");
}
	@Test(groups="integration")
	public void firstName() {
		System.out.println("enter first name");
	
}
	
	@Test(groups="regression testing")
	public void lastName() {
		System.out.println("enter last name");
}
	@Test(groups="system testing")
	public void middleName() {
		System.out.println("enter middle name");
	}
}