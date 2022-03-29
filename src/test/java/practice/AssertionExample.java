package practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AssertionExample {
	@Test
	public void assertionTest() {
		String mobile="micromax";
		String mobile1="micromax";
		
		boolean value=false;
		boolean value2=false;
		
		List<Integer> ls=new ArrayList<Integer>();
		ls.add(10);
		ls.add(20);
		ls.add(30);
		ls.add(40);
		
		List<Integer> ls1=new ArrayList<Integer>();
		ls1.add(10);
		ls1.add(20);
		ls1.add(30);
		ls1.add(40);
		
		List<Object> obj=new ArrayList<Object>();
		obj.add(mobile);
		obj.add(123);
		obj.add("pooja");
		obj.add(true);
		
		List<Object> obj1=new ArrayList<Object>();
		obj1.add(mobile);
		obj1.add(123);
		obj1.add("pooja");
		obj1.add(true);
		
		Set<String> title=new TreeSet<String>();
		title.add("Google");
		title.add("FlipKart");
		title.add("Amazon");
		title.add("Snapdeal");
		
		Set<String> title1=new TreeSet<String>();
		title1.add("Google");
		title1.add("FlipKart");
		title1.add("Amazon");
		title1.add("Snapdeal");
		
		Assert.assertEquals(mobile, mobile1);
		Assert.assertEquals(value, value2);
		Assert.assertEquals(ls, ls1);
		Assert.assertEquals(obj, obj1);
		Assert.assertEquals(title, title1);
			
	}	
	}


