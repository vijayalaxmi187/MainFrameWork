package practice;

import java.time.LocalDateTime;

public class DatePractice {
	public static void main(String[] args) {
		LocalDateTime date = LocalDateTime.now();
		 int day = date.getDayOfMonth();
		System.out.println(day);
		String month = date.getMonth().toString();
		System.out.println(month);
		int year = date.getYear();
		System.out.println(year);
		String actualMonth = month.substring(0, 5).toLowerCase();
        System.out.println(actualMonth);
	}

}
