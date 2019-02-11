package hu.dorsum.javase8.chapter3;

import java.time.LocalTime;
import java.time.ZoneId;
/*
 * Examples:
 * 	Try creating time by providing invalid inputs
 *  Try creating time by providing invalid timezone
 */
public class LocalTimeExample {

	static void run() {
		LocalTime time = LocalTime.now();
		System.out.println("Current Time: " + time);
		
		time = LocalTime.of(20,20,25,40);
		System.out.println("LocalTime by providing input arguments: " + time);
		
		//Current date in "Asia/Kolkata", you can get it from ZoneId javadoc
		LocalTime timeKolkata = LocalTime.now(ZoneId.of("Asia/Kolkata"));
		System.out.println("Current Time in IST: " + timeKolkata);
	
	}
	
}
