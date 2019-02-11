package hu.dorsum.javase8.chapter3;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateParseFormatExample {

	static void run() {
		LocalDate date = LocalDate.now();
		System.out.println("Default format of LocalDate: " + date);
		
		//Specific format
		System.out.println(date.format(DateTimeFormatter.ofPattern("d::MMM::uuuu")));
		System.out.println(date.format(DateTimeFormatter.BASIC_ISO_DATE));		
		
		LocalDateTime dateTime = LocalDateTime.now();
		System.out.println("Default format of LocalDateTime: " + dateTime);
		
		//Specific format
		System.out.println(dateTime.format(DateTimeFormatter.ofPattern("d::MMM::yyyy HH::mm::ss")));
		System.out.println(dateTime.format(DateTimeFormatter.ISO_DATE_TIME));
		
		Instant timestamp = Instant.now();
		System.out.println("Default format of Instant: " + timestamp);
		
	}
	
}
