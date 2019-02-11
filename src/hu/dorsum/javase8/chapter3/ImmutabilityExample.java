package hu.dorsum.javase8.chapter3;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

/*
 * LocalDate instances are immutable, so all calculations on a LocalDate return a new LocalDate.
 * Immutable means that once the constructor for an object has completed execution that instance can't be altered.
 * This is useful as it means you can pass references to the object around, without worrying that someone 
 * else is going to change its contents. 
 * Especially when dealing with concurrency, there are no locking issues with objects that never change.
 * Immutable objects are Thread Safe.
 */
public class ImmutabilityExample {
	
	static void run(boolean isJava8) {				
		if(isJava8) {
			java8Example();
		} else {
			java7Example();
		}				
	}
	
	@SuppressWarnings("deprecation")
	private static void java7Example() {
		Date date = new Date();
		System.out.println("Date: " + date);
		
		//Adds 10 years to 1900 - Deprecated since jdk 1.1
		date.setYear(10);	
		date.setMonth(0);
		System.out.println(date);
		
		//Using calendar
		Calendar cal = Calendar.getInstance();
		date = cal.getTime();
		System.out.println("Cal getTime: " + date);
		
		//Months start at 0, days start at 1.
		cal.set(2010, 1, 1);
		date = cal.getTime();
		System.out.println(date);
		
	}
	
	private static void java8Example() {
		LocalDate ld = LocalDate.of(2018, 01, 01);
		System.out.println("LocalDate: " + ld);
		
		ld.plusYears(10);
		System.out.println("LocalDate + 10 years: " + ld);
		
		ld = ld.plusYears(10);
		System.out.println("LocalDate + 10 years now: " + ld);
	}
	
}
