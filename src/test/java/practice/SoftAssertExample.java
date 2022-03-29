package practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertExample {
	@Test
	public void softAssertTest() {
		int a=10;
		int b=20;
		SoftAssert soft=new SoftAssert();
		soft.assertEquals(a, b);
		Assert.assertEquals(a, b);
		
		
	}

}
