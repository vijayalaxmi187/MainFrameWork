package practice;

import org.testng.annotations.Test;

public class DependsOnMethodTest {
	
	@Test
	public void createAccount() {
		System.out.println("login");
		System.out.println("create Account");
		System.out.println("logot");
	}
	@Test(dependsOnMethods = "createAccount")
	public void modifyAccount() {
		System.out.println("login");
		System.out.println("modify Account");
		System.out.println("logot");
	}
	@Test(dependsOnMethods = "modifyAccount")
	public void deleteAccount() {
		System.out.println("login");
		System.out.println("delete Account");
		System.out.println("logot");
	}
}
