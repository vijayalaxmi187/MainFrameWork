package practice;

import java.time.LocalDateTime;
//import java.time.Month;

public class LocalDateTime1 {

	public static void main(String[] args) {
		  LocalDateTime ldt = LocalDateTime.now();
		  System.out.println(ldt);
		  String date1 = ldt.toString();
		  String date2 = date1.split("T")[0];
		  System.out.println(date2);
		  
		  //String date3 = date1.split("T")[1];
		 // System.out.println(date3);
		 // String month = ldt.getMonth().toString().toLowerCase();
		  //System.out.println(month);
		  
	}

}
