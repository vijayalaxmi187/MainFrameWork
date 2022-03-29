package practice;

import org.testng.annotations.Test;

public class User2information {
	@Test(groups="smoke testing")
	public void studentInfo() {
		System.out.println("student information");
	}
		@Test(groups="integration")
		public void studentName() {
			System.out.println("enter student first name");
		
	}
		
		@Test(groups="regression testing")
		public void studentlastName() {
			System.out.println("student enter last name");
	}
		@Test(groups="system testing")
		public void studentmiddleName() {
			System.out.println("student enter middle name");
		}

}
