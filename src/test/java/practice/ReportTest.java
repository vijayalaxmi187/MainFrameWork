package practice;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.autodeskgenericUtility.BaseClass;

@Listeners(com.crm.autodeskgenericUtility.ListenerImplementationClass.class)
public class ReportTest extends BaseClass {
	@Test
	public void createOrg() {
		System.out.println("passed");
		
	}
	
	@Test
	public void createContact() {
		System.out.println("failed");
		Assert.fail();
		
	}
	
	@Test
	public void createLead() {
		System.out.println("skipped");
		throw new SkipException("skipped");
		
	}
	

}
