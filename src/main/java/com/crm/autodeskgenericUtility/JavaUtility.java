package com.crm.autodeskgenericUtility;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Random;
/**
 * This class contains java specific generic methods
 * @author Vijaylaxmi
 *
 */
public class JavaUtility {
	/**
	 * This method will generate random numbers in the range 0 to 1000
	 * @return int
	 */
public int getRandomNumber() {
	
	Random random = new Random();
	int ranNum = random.nextInt(10000);
	return ranNum;
}
/**
 * This method generate current system date in the format of YYYY-MM-DD with month +1
 * @return String
 */
public String getSystemDate() {
  Date dateObj=new Date();
  String dateAndTime = dateObj.toString();
  @SuppressWarnings("deprecation")
int month = dateObj.getMonth()+1;
  String year = dateAndTime.split(" ")[5];
 String date = dateAndTime.split(" ")[2];
	
	
	 String ddmmyyyyDate= year+ "-" +month+ "-" +date;
	 return ddmmyyyyDate;
}
/**
 * LocalDateAndTime by using ldt.now gives format YYYY-MM-DD
 * @return
 */
public String getSystemDateTime() {
	  LocalDateTime ldt = LocalDateTime.now();
	  String date1 = ldt.toString();
	  String date2 = date1.split("T")[0];
	  return date2;
}
}

